package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Orderlines;

@Repository
@Transactional(readOnly = true)
public interface OrderlinesRepository extends JpaRepository<Orderlines, Integer>{

}
