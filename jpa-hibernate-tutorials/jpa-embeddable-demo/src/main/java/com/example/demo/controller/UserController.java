package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Name;
import com.example.demo.entity.User;
import com.example.demo.entity.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/add")
	private User addUser() {
		Name name = new Name("Rajeev", "Kumar", "Singh");
		Address address = new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008");
		User user = new User(name, "rajeev@callicoder.com", address);
		return userRepository.save(user);
	}
	
	@GetMapping(path="/{id}")
	private User getUser(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping(path="/list")
	private List<User> getUsers() {
		return userRepository.findAll();
	}
}
