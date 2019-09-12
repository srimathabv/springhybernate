package com.hbSpring.repository;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbSpring.model.Employee;

@Repository
public class EmployeeRepo {

	@Autowired
	SessionFactory sf;
	
	@Transactional
	public boolean saveEmployee(Employee emp)
	{
		Session ssn = sf.openSession();
		ssn.save(emp);
		return true;
	}
	@Transactional
	public Employee getEmployee(int empId) {
		
		Session ssn = sf.openSession();
		return ssn.get(Employee.class,empId);
			
	}
	@Transactional
	public List<Employee> getAllEmployees()
	{
		Session ssn = sf.openSession();
		Criteria ctr = ssn.createCriteria(Employee.class);
		return (ctr.list());
	}
	@Transactional
	public boolean deleteEmployee(int empId)
	{
		int id =empId;
		Session ssn = sf.openSession();
		ssn.beginTransaction();
		Query q = ssn.createQuery("delete from Employee where empId=:empId");
		q.setParameter("empId",id);
		
		q.executeUpdate();
		ssn.getTransaction().commit();
		return true;
		
		
	}
	
	
	
	
	
	
}
