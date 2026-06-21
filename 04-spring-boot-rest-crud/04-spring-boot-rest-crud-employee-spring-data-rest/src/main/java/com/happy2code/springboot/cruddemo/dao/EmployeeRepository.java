package com.happy2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.happy2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
