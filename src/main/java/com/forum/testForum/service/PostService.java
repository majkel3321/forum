package com.forum.testForum.service;

import com.forum.testForum.domain.Post;
import com.forum.testForum.domain.PostRepository;
import com.forum.testForum.domain.dto.PostDto;
import com.forum.testForum.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    public List<PostDto> getPosts(){
        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList = new ArrayList<>();

        for(Post post: posts){
            postList.add(post);
        }

        return postMapper.mapToPostDtoList(postList);
    }
}
