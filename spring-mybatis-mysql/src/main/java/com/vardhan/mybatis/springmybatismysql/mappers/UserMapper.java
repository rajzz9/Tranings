package com.vardhan.mybatis.springmybatismysql.mappers;

import com.vardhan.mybatis.springmybatismysql.models.User;

import java.util.List;

public interface UserMapper {

	void insertUser(User user);
	User findUserById(Integer id);
	List<User> findAllUsers();
	void updateUser(User user);
	void removeUser(Integer idUser);

}