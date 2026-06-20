package com.happy2code.springboot.cruddemo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy2code.springboot.cruddemo.dao.EmployeeDAO;
import com.happy2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

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

	@Override
	public Employee findById(int id) {

		// get employee
		Employee theEmployee = entityManager.find(Employee.class, id);

		// return employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {

		// save Employee
		Employee dbEmployee = entityManager.merge(theEmployee);

		// return the dbEmployee
		return dbEmployee;
	}

	@Override
	public void deleteById(int id) {

		// find employee by id
		Employee theEmployee = entityManager.find(Employee.class, id);

		// remove employee
		entityManager.remove(theEmployee);
	}

}
