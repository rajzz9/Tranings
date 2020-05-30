package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentDetail;
import com.example.demo.repository.StudentDetailRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentDetailService {

	@Autowired private StudentDetailRepository studentDetailRepository;
	@Autowired private StudentRepository studentRepository;
	
	public void performAction() {
		Student student = new Student();
		student.setStudent_name("Rajavardhan");
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("88865XX231");
		studentDetail.setStudent(student);
		
		//studentDetailRepository.save(studentDetail);
		
		student.setStudentDetail(studentDetail);
		studentRepository.save(student);
	}
	
	public List<StudentDetail> getAllStudentDetails() {
		return studentDetailRepository.findAll();
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
