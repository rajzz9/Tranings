package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "STUDENT")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="student_id")
public class Student implements java.io.Serializable {

	@Id
	@GeneratedValue
	private int student_id;

	private String student_name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private StudentAddress studentAddress;

	public StudentAddress getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(StudentAddress studentAddress) {
		this.studentAddress = studentAddress;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
}
