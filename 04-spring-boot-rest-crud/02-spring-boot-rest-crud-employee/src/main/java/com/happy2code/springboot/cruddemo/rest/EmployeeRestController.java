package com.happy2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy2code.springboot.cruddemo.dao.EmployeeDAO;
import com.happy2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeRestController(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}

}
