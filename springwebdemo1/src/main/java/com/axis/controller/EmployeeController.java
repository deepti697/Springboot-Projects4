package com.axis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	public EmployeeController(){
		employees.add(new Employee(1,"sachin","Hr"));
		employees.add(new Employee(2,"Deepti","Software Engineer"));
		employees.add(new Employee(3,"Sejal","CS"));
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee(){
		return employees;
	}
	
	@PostMapping("/addEmployee")
	public String addNewEmployee(@RequestBody Employee emp) {
		employees.add(emp);
		return "Employee Added" ;
	}

}
