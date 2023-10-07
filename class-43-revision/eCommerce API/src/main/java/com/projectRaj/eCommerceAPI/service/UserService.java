package com.projectRaj.eCommerceAPI.service;

import com.projectRaj.eCommerceAPI.models.User;
import com.projectRaj.eCommerceAPI.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String createUsers(List<User> users) {
        userRepository.saveAll(users);
        return users.size()+" Users has been added into user repository";
    }
}
