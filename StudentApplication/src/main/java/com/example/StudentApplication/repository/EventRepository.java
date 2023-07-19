package com.example.StudentApplication.repository;

import com.example.StudentApplication.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EventRepository {

    @Autowired @Qualifier("courses")
    private RestTemplate restTemplate;

    public void delete(Student student){
        restTemplate.delete("/"+student.getId());
    }

    public void save(Student student){
        restTemplate.postForEntity("/", student, Void.class);
    }
}
