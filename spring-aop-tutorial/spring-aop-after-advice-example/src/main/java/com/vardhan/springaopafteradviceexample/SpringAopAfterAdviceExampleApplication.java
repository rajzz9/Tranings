package com.vardhan.springaopafteradviceexample;

import com.vardhan.springaopafteradviceexample.model.Employee;
import com.vardhan.springaopafteradviceexample.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopAfterAdviceExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringAopAfterAdviceExampleApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		employeeService.addEmployee(new Employee(100L, "ramesh", "fadatare", "ramesh@gmail.com"));
		employeeService.getEmployeeById(100L);
		employeeService.getAllEmployees();
	}

}
