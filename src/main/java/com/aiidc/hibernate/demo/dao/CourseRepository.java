package com.aiidc.hibernate.demo.dao;

import com.aiidc.hibernate.demo.entity.manytomany.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
