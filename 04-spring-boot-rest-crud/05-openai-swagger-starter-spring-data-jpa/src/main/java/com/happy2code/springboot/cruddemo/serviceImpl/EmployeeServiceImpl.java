package com.happy2code.springboot.cruddemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.happy2code.springboot.cruddemo.dao.*;
import com.happy2code.springboot.cruddemo.entity.Employee;
import com.happy2code.springboot.cruddemo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository EmployeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository EmployeeRepository) {
		this.EmployeeRepository = EmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return EmployeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = EmployeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Did not find employee id!!");
		}
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return EmployeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		EmployeeRepository.deleteById(id);
	}
	
	

}
