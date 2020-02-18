package com.forum.testForum.service;

import com.forum.testForum.domain.User;
import com.forum.testForum.domain.UserRepository;
import com.forum.testForum.domain.dto.UserDto;
import com.forum.testForum.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getUsers(){
        Iterable<User> users = userRepository.findAll();

        List<User> userList = new ArrayList<>();
        for(User user : users) {
            userList.add(user);
        }
        return userMapper.mapToUserDtoList(userList);
    }

    public UserDto getUserById(Long id){
        return userMapper.mapToUserDto(userRepository.findById(id).get());
    }

}
