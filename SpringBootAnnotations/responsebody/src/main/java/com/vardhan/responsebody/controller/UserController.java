package com.vardhan.responsebody.controller;

import com.vardhan.responsebody.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

	@GetMapping("/users")
	public @ResponseBody
	User getUser() {
		User user = new User();
		user.setFirstName("Bushan");
		user.setLastName("Sirgur");
		user.setAge(28L);
		return user;
	}
}