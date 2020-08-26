package com.aiidc.hibernate.demo.entity.manytomany;

import com.aiidc.hibernate.demo.entity.BaseIDEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 课程表
 */
@Entity
@Getter
@Setter
public class Course extends BaseIDEntity {

    private String name;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getId(),course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
