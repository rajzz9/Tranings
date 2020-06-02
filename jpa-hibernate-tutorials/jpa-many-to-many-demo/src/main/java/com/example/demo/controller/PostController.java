package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.model.Tag;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.TagRepository;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/add")
	private Post addPost() {
		// Cleanup the tables
		postRepository.deleteAllInBatch();
		tagRepository.deleteAllInBatch();

		// =======================================

		// Create a Post
		Post post = new Post("Hibernate Many to Many Example with Spring Boot",
				"Learn how to map a many to many relationship using hibernate", "Entire Post content with Sample code");

		// Create two tags
		Tag tag1 = new Tag("Spring Boot");
		Tag tag2 = new Tag("Hibernate");

		// Add tag references in the post
		post.getTags().add(tag1);
		post.getTags().add(tag2);

		// Add post reference in the tags
		tag1.getPosts().add(post);
		tag2.getPosts().add(post);

		return postRepository.save(post);
	}

	@GetMapping(path="/list")
	private List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@GetMapping(path="/tags")
	private List<Tag> getAllTags() {
		return tagRepository.findAll();
	}
}
