package com.example.CourseApplication.controller;

import com.example.CourseApplication.entity.Course;
import com.example.CourseApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable long id) {
        Optional<Course> courseOpt = courseService.findById(id);
        if(courseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseOpt.get());
    }

    @PostMapping()
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        Optional<Course> courseOpt = courseService.findById(course.getId());
        if(courseOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseService.create(course);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@RequestBody Course course, @PathVariable long id) {
        Optional<Course> courseOpt = courseService.findById(id);
        if(courseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        course.setId(id);
        courseService.create(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {
        Optional<Course> courseOpt = courseService.findById(id);
        if(courseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        courseService.delete(courseOpt.get());
        return ResponseEntity.ok().build();
    }
}
