package com.example.StudentApplication.service;

import com.example.StudentApplication.entity.Student;
import com.example.StudentApplication.repository.EventRepository;
import com.example.StudentApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    public Optional<Student> findById(long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void create(Student student){
        studentRepository.save(student);
        eventRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
        eventRepository.delete(student);
    }
}
