package com.vardhan.programming.techi.springbootkeycloak.repository;

import com.vardhan.programming.techi.springbootkeycloak.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
