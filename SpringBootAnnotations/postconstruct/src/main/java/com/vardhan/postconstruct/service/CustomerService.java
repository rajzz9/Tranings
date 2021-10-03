package com.vardhan.postconstruct.service;

import com.vardhan.postconstruct.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	public CustomerService() {
		System.out.println("constructor:customer service");
	}
	
	public Customer get () {
		return new Customer("customer", "india");
	}
}