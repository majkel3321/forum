package com.forum.testForum.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isModerator;
    private List<PostDto> posts;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginDate;
}
