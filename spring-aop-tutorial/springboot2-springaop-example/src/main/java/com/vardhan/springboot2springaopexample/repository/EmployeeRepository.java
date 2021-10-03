package com.vardhan.springboot2springaopexample.repository;

import com.vardhan.springboot2springaopexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}