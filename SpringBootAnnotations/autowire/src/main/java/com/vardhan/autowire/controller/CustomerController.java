package com.vardhan.autowire.controller;

import java.util.List;

import com.vardhan.autowire.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cService;
	
	@GetMapping("/customers")
	public List getList() {
		return cService.getCustomerList();
	}
}