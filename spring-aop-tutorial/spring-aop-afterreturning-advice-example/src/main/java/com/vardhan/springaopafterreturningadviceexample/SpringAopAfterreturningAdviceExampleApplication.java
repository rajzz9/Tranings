package com.vardhan.springaopafterreturningadviceexample;

import com.vardhan.springaopafterreturningadviceexample.model.Employee;
import com.vardhan.springaopafterreturningadviceexample.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopAfterreturningAdviceExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringAopAfterreturningAdviceExampleApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		employeeService.addEmployee(new Employee(100L, "ramesh", "fadatare", "ramesh@gmail.com"));
		employeeService.getEmployeeById(100L);
		employeeService.getAllEmployees();
	}

}
