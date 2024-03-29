package com.vardhan.pathvariable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{userName}")
    public String printUserName(@PathVariable("userName") String name) {
        return "My name is "+name;
    }

    @GetMapping("/users/{name}/{age}/{location}")
    public String printUserInfo(@PathVariable String name,
                                @PathVariable Long age,
                                @PathVariable String location) {
        return "My name is "+name+". I am "+age+" years old. I am living in "+location;
    }
}
