package com.aiidc.hibernate.demo.service;

import com.aiidc.hibernate.demo.dao.StudentRepository;
import com.aiidc.hibernate.demo.entity.manytomany.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list(){
        return studentRepository.findAll();
    }

    public Long save(Student student) {
        studentRepository.save(student);

        return student.getId();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }
}
