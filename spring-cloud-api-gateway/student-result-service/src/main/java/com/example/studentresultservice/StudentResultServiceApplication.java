package com.example.studentresultservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.studentresultservice")
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class StudentResultServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentResultServiceApplication.class, args);
	}

}
