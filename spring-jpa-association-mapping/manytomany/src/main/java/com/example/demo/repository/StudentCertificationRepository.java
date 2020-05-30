package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentCertification;

@Repository
public interface StudentCertificationRepository extends JpaRepository<StudentCertification, Integer>{

}
