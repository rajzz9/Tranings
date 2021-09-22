package com.vardhan.mybatis.springmybatismysql.services;

import com.vardhan.mybatis.springmybatismysql.models.User;

import java.util.List;

public interface UserService {
    
    User create(User user);
    User findById(String userId);
    List<User> findAll();
    User update(User user);
    void delete(User user);

}