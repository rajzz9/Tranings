package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postService.findAll();
	}
	
	@GetMapping("/posts/{id}")
	public Optional<Post> getPostById(@PathVariable Integer id) {
		return postService.findById(id);
	}
	
	@GetMapping("/posts/user/{id}/posts")
	public List<Post> getPostsByUser(@PathVariable Integer id) {
		return postService.findByLocationId(id);
	}

	@PostMapping("/posts/addNew")
	public void AddPost(@RequestBody Post post) {
		postService.AddPost(post);
	}
	
	@PutMapping("/post/{id}/update")
	public void UpdatePost(@RequestBody Post post) {
		postService.UpdatePost(post);
	}
	
	@DeleteMapping("/post/{id}/delete")
	public void DeletePost(@PathVariable Integer id) {
		postService.DeletePost(id);
	}
	
}
