package com.forum.testForum.controller;

import com.forum.testForum.domain.dto.PostDto;
import com.forum.testForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<PostDto> getPosts(){
        return postService.getPosts();
    }
}
