package com.example.StudentApplication.service;

import com.example.StudentApplication.entity.Course;
import com.example.StudentApplication.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void create(Course course) {
        courseRepository.save(course);
    }

    public Optional<Course> findById(long id){
        return courseRepository.findById(id);
    }

    public void delete(Course course){
        courseRepository.delete(course);
    }
}
