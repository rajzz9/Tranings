package com.example.demo.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

	List<Post> findByUserId(Integer id);

}