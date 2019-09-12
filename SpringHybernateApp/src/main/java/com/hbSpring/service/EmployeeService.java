package com.hbSpring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbSpring.model.Employee;
import com.hbSpring.repository.EmployeeRepo;


@Service
public class EmployeeService {

	@Autowired
    EmployeeRepo repo;
	
	public boolean saveEmployee(Employee emp)
	{
		return repo.saveEmployee(emp);
	} 
	
	public Employee getEmployee(int empId)
	{
		return repo.getEmployee(empId);
	}
	
	public boolean deleteEmployee(int empId)
	{
		return repo.deleteEmployee(empId);
	}
	
	public List<Employee> getAllEmployees()
	{
		return repo.getAllEmployees();
	}
}
