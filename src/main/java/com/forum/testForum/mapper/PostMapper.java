package com.forum.testForum.mapper;

import com.forum.testForum.domain.Post;
import com.forum.testForum.domain.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public List<PostDto> mapToPostDtoList(List<Post> posts){
        return posts.stream()
                .map(post -> new PostDto(post.getId(),post.getSubject(),post.getMessage(),
                        post.getUser().getId(),post.getDateTime())).collect(Collectors.toList());
    }

    public PostDto mapToPostDto(Post post){
        return new PostDto(post.getId(),post.getSubject(),post.getMessage(),post.getUser().getId(),post.getDateTime());
    }
}
