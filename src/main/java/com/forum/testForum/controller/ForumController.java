package com.forum.testForum.controller;

import com.forum.testForum.domain.Post;
import com.forum.testForum.domain.PostRepository;
import com.forum.testForum.domain.User;
import com.forum.testForum.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        User user1 = new User("Kris1","krissPass1");
        User user2 = new User("Kris2","krissPass2");
        User user3 = new User("Kris3","krissPass3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Post post1 = new Post("sub1","welcome1",user1);
        Post post2 = new Post("sub2","welcome2",user1);
        Post post3 = new Post("sub3","welcome3",user2);
        Post post4 = new Post("sub4","welcome4",user3);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
    }
}
