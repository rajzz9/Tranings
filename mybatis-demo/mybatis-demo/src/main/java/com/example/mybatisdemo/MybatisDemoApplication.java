package com.example.mybatisdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class MybatisDemoApplication {

    @Bean
    ApplicationRunner runner(CarMapper carMapper) {
        return args -> {
            Stream.of("A", "B").forEach(name -> carMapper.insert(new Car(name, 2018, null)));
            carMapper.search("A", 2018).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }
}

