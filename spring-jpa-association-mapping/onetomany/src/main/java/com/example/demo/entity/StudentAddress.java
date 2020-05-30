package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "STUDENTADDRESS")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="address_id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "students"})
public class StudentAddress implements java.io.Serializable {

	@Id
	@GeneratedValue
	private int address_id;

	private String address_detail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentAddress")
	//@OneToMany(cascade = CascadeType.ALL)  //=> Hibernate will create one new table for mapping between studentaddress and student table
	//@JsonBackReference
	private Set<Student> students = new HashSet<Student>(0);

	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

}
