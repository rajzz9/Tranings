package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentCertification;
import com.example.demo.repository.StudentCertificationRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired StudentRepository studentRepository;
	@Autowired StudentCertificationRepository studentCertificationRepository;
	
	public void performAction() {
		
		StudentCertification studentCertification1 = new StudentCertification();
		studentCertification1.setCertification_name("Core java Ceritification Exam");
		
		StudentCertification studentCertification2 = new StudentCertification();
		studentCertification2.setCertification_name("Oracle DB Ceritification Exam");
		
		
		Student student1 = new Student();
		student1.setStudent_name("Raj1");
		(student1.getStudentCertification()).add(studentCertification1);
		
		Student student2 = new Student();
		student2.setStudent_name("Raj1");
		(student2.getStudentCertification()).add(studentCertification2);
		
		studentRepository.save(student1);
		studentRepository.save(student2);
	}
	
}
