package com.vardhan.valid.controller;

import javax.validation.Valid;

import com.vardhan.valid.entity.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@PostMapping("/test")
	public String test (@Valid @RequestBody Customer customer) {
		return "Success";
	}

}