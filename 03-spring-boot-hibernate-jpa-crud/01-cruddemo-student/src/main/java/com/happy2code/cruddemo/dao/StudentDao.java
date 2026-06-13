package com.happy2code.cruddemo.dao;

import java.util.List;

import com.happy2code.cruddemo.entity.Student;

public interface StudentDao {

    void save (Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllStudentsById(String email);

    Student updateStudent(Student theStudent);
}
