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


    public void startFollowing(User follower, User target) {

        Follow follow = new Follow(null,target,follower);
        followRepo.save(follow);
    }

    public boolean findByTargetAndFollower(User follower, User target) {

       List<Follow> follows =  followRepo.findByCurrentUserAndCurrentUserFollower(target,follower);

       return !follows.isEmpty();
    }
}
