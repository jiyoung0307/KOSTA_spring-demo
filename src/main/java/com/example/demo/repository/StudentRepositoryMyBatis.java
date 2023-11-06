package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentRepositoryMyBatis {
    List<Student> findAll();
    Student findById(int studentId);
    Student removeById(int studentId);
    Student add(Student student);
    Student update(int studentId, Student student);
}
