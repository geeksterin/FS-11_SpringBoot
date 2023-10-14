package com.geekster.InstaBackend.service;


import com.geekster.InstaBackend.model.Like;
import com.geekster.InstaBackend.model.Post;
import com.geekster.InstaBackend.model.User;
import com.geekster.InstaBackend.repository.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LikeService {

    @Autowired
    ILikeRepo likeRepo;




}
