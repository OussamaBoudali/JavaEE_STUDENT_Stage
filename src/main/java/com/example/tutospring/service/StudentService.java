package com.example.tutospring.service;

import com.example.tutospring.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
    void updateStudent(Long id, Student student);
}
