package com.geekster.InstaBackend.repository;

import com.geekster.InstaBackend.model.Admin;
import com.geekster.InstaBackend.model.Comment;
import com.geekster.InstaBackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
    List<Comment> findByInstaPost(Post myPost);
}
