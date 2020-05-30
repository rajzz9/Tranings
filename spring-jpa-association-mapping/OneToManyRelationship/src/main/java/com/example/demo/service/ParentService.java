package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Parent;
import com.example.demo.repository.ParentRepository;

@Service
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;

	public Parent createParent(Parent parent) {
		return parentRepository.save(parent);
	}
}
