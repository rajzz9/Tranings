package com.vardhan.mybatis.springmybatismysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vardhan.mybatis.springmybatismysql.mappers")
public class SpringMybatisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisMysqlApplication.class, args);
	}

}
