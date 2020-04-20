package com.example.studentresultservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.studentresultservice")
public class StudentResultServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentResultServiceApplication.class, args);
	}

}
