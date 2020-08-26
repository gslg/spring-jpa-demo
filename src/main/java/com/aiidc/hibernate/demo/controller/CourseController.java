package com.aiidc.hibernate.demo.controller;

import com.aiidc.hibernate.demo.entity.manytomany.Course;
import com.aiidc.hibernate.demo.entity.manytomany.Student;
import com.aiidc.hibernate.demo.service.CourseService;
import com.aiidc.hibernate.demo.service.StudentService;
import com.aiidc.hibernate.demo.vo.CourseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseVO> getStudent(@PathVariable Long id) {
        Course course = courseService.getById(id);
        return ResponseEntity.ok(new CourseVO(
                String.valueOf(course.getId()),
                course.getName()));
    }

    @GetMapping
    public ResponseEntity<List<CourseVO>> getStudents() {
        return ResponseEntity.ok(
                courseService.list()
                        .stream()
                        .map(e -> new CourseVO(String.valueOf(e.getId()), e.getName()))
                        .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity saveCourse(@RequestBody Course req) {
        Course course = new Course();
        course.setName(req.getName());

        Long id = courseService.save(course);

        return ResponseEntity.ok(id);
    }
}
