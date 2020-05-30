package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Post;
import com.example.demo.models.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	public Optional<Post> findById(Integer id) {
		return postRepository.findById(id);
	}

	public List<Post> findByLocationId(Integer id) {
		return postRepository.findByUserId(id);
	}

	public void AddPost(Post post) {
		postRepository.save(post);
	}
	
	public void UpdatePost(Post post) {
		postRepository.save(post);
	}

	public void DeletePost(Integer id) {
		postRepository.deleteById(id);
	}
	
}