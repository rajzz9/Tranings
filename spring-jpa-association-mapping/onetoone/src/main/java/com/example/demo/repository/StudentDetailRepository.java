package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentDetail;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail, Integer> {

}
