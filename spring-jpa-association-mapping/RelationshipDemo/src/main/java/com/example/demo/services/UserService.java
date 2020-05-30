package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.models.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public List<User> getUsersByLocation(Integer id) {
		return userRepository.findByLocationId(id);
	}
	
	public void AddUser(User user) {
		userRepository.save(user);
	}

	public void UpdateUser(User user) {
		userRepository.save(user);
	}

	public void DeleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
}
