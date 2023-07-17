package com.example.StudentApplication.controller;

import com.example.StudentApplication.entity.Student;
import com.example.StudentApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> studentOpt = studentService.findById(id);
        if(studentOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentOpt.get());
    }

    @PostMapping()
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        Optional<Student> studentOpt = studentService.findById(student.getId());
        if(studentOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        studentService.create(student);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student, @PathVariable long id) {
        Optional<Student> studentOpt = studentService.findById(id);
        if(studentOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        studentService.create(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        Optional<Student> studentOpt = studentService.findById(id);
        if(studentOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
