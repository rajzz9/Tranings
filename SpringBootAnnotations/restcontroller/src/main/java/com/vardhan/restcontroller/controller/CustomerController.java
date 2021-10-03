package com.vardhan.restcontroller.controller;

import com.vardhan.restcontroller.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@GetMapping("/customer")
	public Customer getCustomer () {
		Customer c = new Customer("Bushan", "India");
		return c;
	}
}