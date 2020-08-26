package com.aiidc.hibernate.demo.entity.manytomany;

import com.aiidc.hibernate.demo.entity.BaseIDEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student extends BaseIDEntity {

    private String name;

    private Integer age;

    private LocalDateTime createTime;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> likedCourses = new HashSet<>();

    public void addCourse(Course course) {
        likedCourses.add(course);
        course.getLikes().add(this);
    }

    public void removeCourse(Course course) {
        likedCourses.remove(course);
        course.getLikes().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
