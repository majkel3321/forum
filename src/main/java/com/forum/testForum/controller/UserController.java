package com.forum.testForum.controller;

import com.forum.testForum.domain.dto.UserDto;
import com.forum.testForum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping
    public UserDto findById(@RequestParam Long id){
        return userService.getUserById(id);
    }
}
