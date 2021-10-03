package com.vardhan.exceptionhandler.controller;

import com.vardhan.exceptionhandler.entity.Employee;
import com.vardhan.exceptionhandler.exceptions.EmployeeNotFoundException;
import com.vardhan.exceptionhandler.exceptions.ErrorObject;
import com.vardhan.exceptionhandler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService eService;
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee (@PathVariable Integer id) {
		return eService.getEmployee(id);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleException(EmployeeNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);
	}
}