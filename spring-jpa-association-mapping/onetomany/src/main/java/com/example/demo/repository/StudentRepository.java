package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT s FROM Student s WHERE s.studentAddress.address_id = :id")
	public List<Student> findByStudentAddress(@Param("id") int id);
}
