package com.aiidc.hibernate.demo.dao;

import com.aiidc.hibernate.demo.entity.manytomany.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Long> {
}
