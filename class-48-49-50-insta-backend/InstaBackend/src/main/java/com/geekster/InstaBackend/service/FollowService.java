package com.geekster.InstaBackend.service;

import com.geekster.InstaBackend.model.Follow;
import com.geekster.InstaBackend.model.User;
import com.geekster.InstaBackend.repository.IFollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    IFollowRepo followRepo;




}
