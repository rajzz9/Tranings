package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	private User addEmployee() {
		// Cleanup database tables.
		userRepository.deleteAll();

		// Insert a user with multiple phone numbers and addresses.
		Set<String> phoneNumbers = new HashSet<>();
		phoneNumbers.add("+91-9999999999");
		phoneNumbers.add("+91-9898989898");

		Set<Address> addresses = new HashSet<>();
		addresses.add(new Address("747", "Golf View Road", "Bangalore", "Karnataka", "India", "560008"));
		addresses.add(new Address("Plot No 44", "Electronic City", "Bangalore", "Karnataka", "India", "560001"));

		User user = new User("Rajeev Kumar Singh", "rajeev@callicoder.com", phoneNumbers, addresses);

		return userRepository.save(user);
	}

	@GetMapping(path = "/list")
	private List<User> getAllEmployee() {
		return userRepository.findAll();
	}

}
