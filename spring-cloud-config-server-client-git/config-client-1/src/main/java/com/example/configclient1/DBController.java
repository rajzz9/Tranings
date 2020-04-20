package com.example.configclient1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DBController {

	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	
	@RequestMapping(value="/db", method=RequestMethod.GET)
	public String getDBDetails() {
		Map<String, String> dbMap = new HashMap<>();
		dbMap.put("driverClassName", driverClassName);
		dbMap.put("url", url);
		dbMap.put("username", username);
		dbMap.put("password", password);
		
		return dbMap.toString();
	}
	
}
