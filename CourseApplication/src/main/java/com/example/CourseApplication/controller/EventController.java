package com.example.CourseApplication.controller;

import com.example.CourseApplication.entity.Student;
import com.example.CourseApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        studentService.create(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        Optional<Student> studentOpt = studentService.findById(id);
        if(studentOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(studentOpt.get());
        return ResponseEntity.ok().build();
    }
}
