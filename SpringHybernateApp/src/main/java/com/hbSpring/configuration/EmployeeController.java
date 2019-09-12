package com.hbSpring.configuration;

import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbSpring.model.Employee;
import com.hbSpring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
	public  String addEmployee(@ModelAttribute Employee emp, Model m)
	{
		String msg = "failed.....";
		if(service.saveEmployee(emp))
			msg = "sucessfull.....";
		 m.addAttribute("msg",msg);
		 return "view.jsp" ;
	
		
	}
	
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("id") int empId, Model m)
	{
		Employee emp =service.getEmployee(empId);
		m.addAttribute("emp", emp);
		return "viewemp.jsp";
	}
	
	@GetMapping("/employees")
	public String getallEmployees(Model m)
	
	{
		List<Employee> emplist = service.getAllEmployees();
		m.addAttribute("emplist", emplist);
		return "viewall.jsp";
	}
	
	
	@PostMapping("/delete")
	public  String deleteEmployee(@RequestParam("id") int empId,Model m)
	{
		
	
		String msg = "Failed..";
		//Employee emp = service.getEmployee(empId)
		if(service.deleteEmployee(empId))
			msg = "sucessfull.....";
		 m.addAttribute("msg",msg);
		 return "view.jsp" ;
	}
	
	
	
	
	
	
	
	
}
