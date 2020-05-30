package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentAddress;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	private String performAction() {
		studentService.performAction();
		return "Done";
	}

	@GetMapping("{id}/allstudents")
	private List<Student> getAllStudents(@PathVariable int id) {
		return studentService.getAllStudents(id);
	}
	
	@GetMapping("/alladdress")
	private List<StudentAddress> getAllAddress() {
		return studentService.getAllStudentAddress();
	}
}
