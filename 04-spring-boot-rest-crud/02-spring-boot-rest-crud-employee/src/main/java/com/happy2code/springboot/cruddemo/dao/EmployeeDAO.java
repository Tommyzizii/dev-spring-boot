package com.happy2code.springboot.cruddemo.dao;

import java.util.List;

import com.happy2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int id);
	

}
