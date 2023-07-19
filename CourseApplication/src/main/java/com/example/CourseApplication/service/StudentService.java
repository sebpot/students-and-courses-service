package com.example.CourseApplication.service;

import com.example.CourseApplication.entity.Student;
import com.example.CourseApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findById(long id){
        return studentRepository.findById(id);
    }

    public void create(Student student){
        studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }
}
