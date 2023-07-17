package com.example.StudentApplication.service;

import com.example.StudentApplication.entity.Student;
import com.example.StudentApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findById(long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void create(Student student){
        studentRepository.save(student);
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }
}
