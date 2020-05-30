package com.example.demo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;

@Service
public class ChildService {

	@Autowired
	private ChildRepository childRepository;

	@Autowired
	private ParentRepository parentRepository;

	public Optional<Child> getChildById(int childId) {
		if (!childRepository.existsById(childId)) {
			throw new ResourceNotFoundException("Book with id " + childId + " not found");
		}
		return childRepository.findById(childId);
	}

	public Child createChild(int childId, Child child) {
		Set<Child> children = new HashSet<>();
		Parent parent = new Parent();

		Optional<Parent> byId = parentRepository.findById(childId);
		if (!byId.isPresent()) {
			throw new ResourceNotFoundException("Parent with id " + childId + " does not exist");
		}
		Parent parent1 = byId.get();

		// tie Author to Book
		child.setParent(parent1);

		Child child1 = childRepository.save(child);
		// tie Book to Author
		children.add(child1);
		parent.setChildren(children);

		return child1;

	}
}
