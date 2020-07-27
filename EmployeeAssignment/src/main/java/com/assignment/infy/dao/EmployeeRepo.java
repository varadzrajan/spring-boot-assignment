package com.assignment.infy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.infy.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
	

}
