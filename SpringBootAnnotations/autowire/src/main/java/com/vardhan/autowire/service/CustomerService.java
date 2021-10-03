package com.vardhan.autowire.service;

import java.util.ArrayList;
import java.util.List;

import com.vardhan.autowire.entity.Customer;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	private static List list = new ArrayList<>();
	static {
		Customer c = new Customer();
		c.setId(1L);
		c.setName("Customer 1");
		c.setAge(28L);
		c.setLocation("India");
		list.add(c);
		
		c = new Customer();
		c.setId(2L);
		c.setName("Customer 2");
		c.setAge(30L);
		c.setLocation("India");
		list.add(c);
		
		c = new Customer();
		c.setId(3L);
		c.setName("Customer 3");
		c.setAge(31L);
		c.setLocation("India");
		list.add(c);
	}
	
	public List getCustomerList() {
		return list;
	}
}