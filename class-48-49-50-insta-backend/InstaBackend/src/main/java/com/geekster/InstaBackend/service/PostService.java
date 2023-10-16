package com.geekster.InstaBackend.service;


import com.geekster.InstaBackend.model.Post;
import com.geekster.InstaBackend.repository.IPostRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;


    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;





    public void createInstaPost(Post instaPost) {

        //set creation time before saving :
        instaPost.setPostCreatedTimeStamp(LocalDateTime.now());

        postRepo.save(instaPost);
    }

    public Post getPostById(Integer postId) {
      return  postRepo.findById(postId).orElseThrow();

    }


    @Transactional
    public void removeById(Integer postId) {

        Post myPost = postRepo.findById(postId).orElseThrow();

        //delete all likes
        likeService.clearLikesByPost(myPost);


        // delete all comments
        commentService.clearCommentsByPost(myPost);

        //finally delete post
        postRepo.deleteById(postId);
    }
}
