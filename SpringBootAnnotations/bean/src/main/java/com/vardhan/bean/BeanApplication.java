package com.vardhan.bean;

import com.vardhan.bean.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanApplication.class);
		//By its type
		UserService user = ctx.getBean(UserService.class);

		//By its alias name
		UserService user1 = (UserService)ctx.getBean("myBean");

		System.out.println("Printing user:"+user1.getList());
	}

}
