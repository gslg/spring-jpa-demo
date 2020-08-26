package com.aiidc.hibernate.demo.controller;

import com.aiidc.hibernate.demo.entity.manytomany.Course;
import com.aiidc.hibernate.demo.entity.manytomany.Student;
import com.aiidc.hibernate.demo.service.StudentService;
import com.aiidc.hibernate.demo.vo.CourseVO;
import com.aiidc.hibernate.demo.vo.CreateStudentVO;
import com.aiidc.hibernate.demo.vo.StudentVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentVO> getStudent(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(StudentVO.of(student));
    }

    @GetMapping
    public ResponseEntity<List<StudentVO>> getStudents() {
        return ResponseEntity.ok(studentService.list().stream().map(e -> StudentVO.of(e)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody CreateStudentVO req) {

        Student student = merge(req, new Student());

        student.setCreateTime(LocalDateTime.now());

        Long id = studentService.save(student);

        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody CreateStudentVO req) {

        Student student = studentService.getById(id);

        merge(req, student);

        studentService.save(student);

        return ResponseEntity.ok(id);
    }

    @PostMapping("/{id}/course")
    public void addCourse(@PathVariable Long id,@RequestBody Course course){
        Student student = studentService.getById(id);
        student.addCourse(course);
    }

    @DeleteMapping("/{id}/course")
    public void removeCourse(@PathVariable Long id,@RequestBody Course course){
        Student student = studentService.getById(id);
        student.removeCourse(course);
    }

    private Student merge(CreateStudentVO vo, Student student) {
        student.setName(vo.getName());
        student.setAge(vo.getAge());

        return student;
    }


}
