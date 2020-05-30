package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentAddress;
import com.example.demo.repository.StudentAddressRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired private StudentRepository studentRepository;
	@Autowired private StudentAddressRepository studentAddressRepository;
	
	public void performAction() {
		StudentAddress studentAddress = new StudentAddress();
		studentAddress.setAddress_detail("Hyderabad, India");
		
		Student student1 = new Student();
		student1.setStudent_name("Raja1");
		student1.setStudentAddress(studentAddress);
		
		Student student2 = new Student();
		student2.setStudent_name("Raja2");
		student2.setStudentAddress(studentAddress);
		
		studentRepository.save(student1);
		studentRepository.save(student2);
		
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
