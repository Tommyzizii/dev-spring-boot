package com.happy2code.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.happy2code.springboot.cruddemo.entity.Employee;
import com.happy2code.springboot.cruddemo.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	private JsonMapper jsonMapper;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper) {
		this.employeeService = employeeService;
		this.jsonMapper = jsonMapper;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found-" + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// in case they pass an id in JSON ... set id to 0
		// to force a save of a new item ... instead of update
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad) {
		
		Employee temEmployee = employeeService.findById(employeeId);
		
		if (temEmployee == null) {
			throw new RuntimeException("Employee Id not found");
		}
		
		if (patchPayLoad.containsKey("id")) {
			throw new RuntimeException("Employee id not allowed in request body");
		}
		
		Employee patchedEmployee = jsonMapper.updateValue(temEmployee, patchPayLoad);
		
		Employee dbEmployee = employeeService.save(patchedEmployee);
		
		return dbEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee temEmployee =  employeeService.findById(employeeId);
		
		if (temEmployee == null) {
			throw new RuntimeException("Employee not found");
		}
		
		employeeService.deleteById(employeeId);
		
		return "Delete Employee Id -" + employeeId ;
	}

}




























