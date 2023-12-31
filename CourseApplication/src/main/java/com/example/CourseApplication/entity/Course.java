package com.example.CourseApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="courses")
public class Course {
    @Id
    private long id;

    private String title;

    private String description;

    private double price;

    @ManyToMany
    private List<Student> students;
}
