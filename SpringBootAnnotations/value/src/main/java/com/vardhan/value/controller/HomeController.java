package com.vardhan.value.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version:version1}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppVersion () {
		return appName+" - "+appVersion;
	}
}