package com.vardhan.postconstruct.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.vardhan.postconstruct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cService;
	
	public CustomerController() {
		System.out.println("constructor: customer controller"); 
	}
	
	@PostConstruct
	public void getCustomer () {
		System.out.println("getCustomer() is calling");
		System.out.println(cService.get());
	}
}