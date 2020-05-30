package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentAddress;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer>{

}
