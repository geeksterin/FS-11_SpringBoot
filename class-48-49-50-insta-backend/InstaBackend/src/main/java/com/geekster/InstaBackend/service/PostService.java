package com.geekster.InstaBackend.service;


import com.geekster.InstaBackend.model.Post;
import com.geekster.InstaBackend.model.User;
import com.geekster.InstaBackend.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;


    public void createInstaPost(Post instaPost) {
        postRepo.save(instaPost);
    }

    public Post getPostById(Integer postId) {
      return  postRepo.findById(postId).orElseThrow();

    }

    public void removeById(Integer postId) {

        //delete all likes


        // delete all comments


        //finally delete post

    }
}
