package com.forum.testForum.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PostDto {

    private Long id;
    private String subject;
    private String message;
    private Long userId;
    private LocalDateTime dateTime;
}
