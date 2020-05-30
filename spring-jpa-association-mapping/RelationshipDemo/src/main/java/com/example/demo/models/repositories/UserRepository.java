package com.example.demo.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByLocationId(Integer id);

}