package com.forum.testForum.mapper;

import com.forum.testForum.domain.User;
import com.forum.testForum.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private PostMapper postMapper;

    public UserDto mapToUserDto(User user){
        return new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.isAdmin(),
                user.isModerator(),postMapper.mapToPostDtoList(user.getPosts()),user.getRegistrationDate(),user.getLastLoginDate());
    }

    public List<UserDto> mapToUserDtoList(List<User> users){
        return users.stream()
                .map(user -> new UserDto(user.getId(),user.getUsername(),user.getPassword(),user.isAdmin(),
                        user.isModerator(),postMapper.mapToPostDtoList(user.getPosts()),user.getRegistrationDate(),user.getLastLoginDate())).collect(Collectors.toList());
    }
}
