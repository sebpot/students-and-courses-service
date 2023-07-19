package com.example.CourseApplication.service;

import com.example.CourseApplication.entity.Course;
import com.example.CourseApplication.repository.CourseRepository;
import com.example.CourseApplication.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EventRepository eventRepository;

    public Optional<Course> findById(long id){
        return courseRepository.findById(id);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void create(Course course){
        courseRepository.save(course);
        eventRepository.save(course);
    }

    public void delete(Course course){
        courseRepository.delete(course);
        eventRepository.save(course);
    }
}
