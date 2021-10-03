package com.vardhan.springaopafterthrowingadviceexample;

import com.vardhan.springaopafterthrowingadviceexample.model.Employee;
import com.vardhan.springaopafterthrowingadviceexample.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopAfterthrowingAdviceExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(SpringAopAfterthrowingAdviceExampleApplication.class, args);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		employeeService.addEmployee(new Employee(100L, "ramesh", "fadatare", "ramesh@gmail.com"));

		// passing different id so that method throw exception
		try{
			employeeService.getEmployeeById(200L);
		}catch (Exception e){
			System.out.println(e.getCause());
		}

		employeeService.getAllEmployees();
	}

}
