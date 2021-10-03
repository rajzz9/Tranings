package com.vardhan.bean.service;

import com.vardhan.bean.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserService {
	
	private static List list = new ArrayList<>(); 
	
	static {
		User u = new User("User 1");
		list.add(u);
		
		u = new User("User 2");
		list.add(u);
		
		u = new User("User 3");
		list.add(u);
	}
	
	public List getList () {
		return list;
	}
}