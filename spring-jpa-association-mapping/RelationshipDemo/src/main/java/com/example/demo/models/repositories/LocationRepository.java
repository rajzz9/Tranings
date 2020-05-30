package com.example.demo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>  {

}