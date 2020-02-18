package com.forum.testForum.controller;

import com.forum.testForum.domain.User;
import com.forum.testForum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping
    public User findById(@RequestParam Long id){
        return userService.getUserById(id);
    }
}
