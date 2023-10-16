package com.geekster.InstaBackend.service;

import com.geekster.InstaBackend.model.Comment;
import com.geekster.InstaBackend.model.Like;
import com.geekster.InstaBackend.model.Post;
import com.geekster.InstaBackend.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public void clearCommentsByPost(Post myPost) {

        List<Comment> commentsOfPost = commentRepo.findByInstaPost(myPost);
        commentRepo.deleteAll(commentsOfPost);
    }

    public void addComment(Comment newComment) {
        commentRepo.save(newComment);
    }

    public Comment findCommentById(Integer commentId) {
        return commentRepo.findById(commentId).orElseThrow();
    }

    public void removeCommentById(Integer commentId) {
        commentRepo.deleteById(commentId);
    }
}
