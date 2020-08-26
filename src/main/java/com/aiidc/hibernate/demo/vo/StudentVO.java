package com.aiidc.hibernate.demo.vo;

import com.aiidc.hibernate.demo.entity.manytomany.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
    private String id;
    private String name;
    private int age;

    public static StudentVO of(Student student) {
        return new StudentVO(
                String.valueOf(student.getId()),
                student.getName(),
                student.getAge());
    }
}
