package com.vardhan.springaoparoundadviceexample;

import com.vardhan.springaoparoundadviceexample.model.Employee;
import com.vardhan.springaoparoundadviceexample.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopAroundAdviceExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringAopAroundAdviceExampleApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		employeeService.addEmployee(new Employee(100L, "ramesh", "fadatare", "ramesh@gmail.com"));
		employeeService.getEmployeeById(100L);
		employeeService.getAllEmployees();
	}

}
