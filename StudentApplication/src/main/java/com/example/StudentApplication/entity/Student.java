package com.example.StudentApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    private long id;

    private String name;

    private String lastName;

    private int age;

    @ManyToMany
    private List<Course> courses;
}
