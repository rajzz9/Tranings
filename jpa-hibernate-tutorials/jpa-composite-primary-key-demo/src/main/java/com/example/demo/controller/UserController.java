package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeIdentity;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path="/add")
	private Employee addEmployee() {
		// Cleanup employees table
		employeeRepository.deleteAllInBatch();

		// Insert a new Employee in the database
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"), "Rajeev Kumar Singh",
				"rajeev@callicoder.com", "+91-9999999999");

		return employeeRepository.save(employee);

		// Retrieving an Employee Record with the composite primary key
		//employeeRepository.findById(new EmployeeIdentity("E-123", "D-457"));

		// Retrieving all the employees of a particular company
		//employeeRepository.findByEmployeeIdentityCompanyId("D-457");
	}
	
	@GetMapping(path="/list")
	private List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
