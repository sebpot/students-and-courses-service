package com.example.CourseApplication.repository;

import com.example.CourseApplication.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EventRepository {

    @Autowired @Qualifier("students")
    private RestTemplate restTemplate;

    public void delete(Course course){
        restTemplate.delete("/"+course.getId());
    }

    public void save(Course course){
        restTemplate.postForEntity("/", course, Void.class);
    }
}
