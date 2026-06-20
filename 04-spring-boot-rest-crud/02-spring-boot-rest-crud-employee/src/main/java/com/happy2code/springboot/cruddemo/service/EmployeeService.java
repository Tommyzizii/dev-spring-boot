package com.happy2code.springboot.cruddemo.service;

import java.util.List;

import com.happy2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

}
