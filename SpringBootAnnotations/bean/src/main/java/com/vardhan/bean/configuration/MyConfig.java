package com.vardhan.bean.configuration;

import com.vardhan.bean.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {
	
	@Bean(name={"myBean", "mySecondBean"})
    public UserService getUser() {
        return new UserService();
    }
}