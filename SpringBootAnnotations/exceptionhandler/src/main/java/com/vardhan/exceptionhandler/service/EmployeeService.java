package com.vardhan.exceptionhandler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vardhan.exceptionhandler.entity.Employee;
import com.vardhan.exceptionhandler.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee(1, "Employee 1", 28, "India");
		list.add(e);
		
		e = new Employee(2, "Employee 2", 25, "India");
		list.add(e);
		
		e = new Employee(3, "Employee 3", 30, "India");
		list.add(e);
		
		e = new Employee(4, "Employee 4", 48, "India");
		list.add(e);
		
		e = new Employee(5, "Employee 5", 27, "India");
		list.add(e);
	}
	
	public Employee getEmployee (Integer id) {
		Optional<Employee> theEmployee = list.stream().filter(e -> e.getId() == id).findFirst();
		if (theEmployee.isPresent()) {
			return theEmployee.get();
		}
		throw new EmployeeNotFoundException("Employee not found for the id ->"+id);
	}
}