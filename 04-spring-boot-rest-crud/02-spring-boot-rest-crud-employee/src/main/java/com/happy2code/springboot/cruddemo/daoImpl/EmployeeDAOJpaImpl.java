package com.happy2code.springboot.cruddemo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy2code.springboot.cruddemo.dao.EmployeeDAO;
import com.happy2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
		
	}

}
