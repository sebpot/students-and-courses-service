package com.example.StudentApplication.controller;

import com.example.StudentApplication.entity.Course;
import com.example.StudentApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private CourseService courseService;

    @PostMapping()
    public ResponseEntity<Void> createCourse(@RequestBody Course course){
        courseService.create(course);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id){
        Optional<Course> courseOpt = courseService.findById(id);
        if(courseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        courseService.delete(courseOpt.get());
        return ResponseEntity.ok().build();
    }
}
