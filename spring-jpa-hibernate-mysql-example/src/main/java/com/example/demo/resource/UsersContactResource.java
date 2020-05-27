package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.model.UsersContact;
import com.example.demo.model.UsersLog;
import com.example.demo.repository.UsersContactRepository;

@RestController
@RequestMapping("/rest/userscontact")
public class UsersContactResource {

	private UsersContactRepository usersContactRepository;
	
	public UsersContactResource(UsersContactRepository usersContactRepository) {
		this.usersContactRepository = usersContactRepository;
	}

	@GetMapping(value="/all")
	public List<UsersContact> getUsersContact() {
		return this.usersContactRepository.findAll();
	}
	
	@GetMapping(value="/update/{name}")
	public List<UsersContact> update(@PathVariable String name) {
		
		Users user = new Users();
		UsersContact usersContact = new UsersContact();
		UsersLog userslog1 = new UsersLog();
		userslog1.setLog("HI Youtube");
		
		UsersLog userslog2 = new UsersLog();
		userslog2.setLog("HI Viewers");

		user.setTeamName("Development").setSalary(10000).setName(name).setUsersLog(Arrays.asList(userslog1, userslog2));
		usersContact.setPhoneNo(11111111).setUsers(user);
		
		usersContactRepository.save(usersContact);
		
		return usersContactRepository.findAll();
	}
}
