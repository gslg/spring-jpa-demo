package com.aiidc.hibernate.demo.service;

import com.aiidc.hibernate.demo.dao.CourseRepository;
import com.aiidc.hibernate.demo.dao.StudentRepository;
import com.aiidc.hibernate.demo.entity.manytomany.Course;
import com.aiidc.hibernate.demo.entity.manytomany.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> list(){
        return courseRepository.findAll();
    }

    public Long save(Course course) {
        courseRepository.save(course);

        return course.getId();
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }
}
