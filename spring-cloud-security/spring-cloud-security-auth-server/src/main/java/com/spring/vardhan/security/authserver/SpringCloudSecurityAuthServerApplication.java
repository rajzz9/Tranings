package com.spring.vardhan.security.authserver;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringCloudSecurityAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityAuthServerApplication.class, args);
	}
	
	// http://localhost:9000/service/user
	// method: GET
	// headers: 
		// key: Authorization
		// value: bearer <acces_token>
	@RequestMapping("/user")
	Principal getUser(Principal user){
		return user;
	}

	//http://localhost:9000/service/oauth/token
	//Authorization   Basic auth
		// username: rajzz9
		// password: test
	// Body
		//x-www-form-unlencoded
		//key: grant_type : password
		//key: client_id : rajzz9
		//key: username : allen
		//key: password : password1
	
}
