package com.happy2code.cruddemo.dao;

import com.happy2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save (Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllStudentsById(String email);
}
