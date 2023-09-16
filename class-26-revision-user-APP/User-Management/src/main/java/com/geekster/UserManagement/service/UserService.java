package com.geekster.UserManagement.service;


import com.geekster.UserManagement.entity.User;
import com.geekster.UserManagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUser() {
       return userRepo.getUsrList();
    }

    public String addUsers(List<User> myUsers) {

        getAllUser().addAll(myUsers);

        return myUsers.size() + " users were added!";
    }

    public String updatePasswordByUserId(Integer id, String password) {

        for(User user : getAllUser())
        {
            if(user.getUserId().equals(id))
            {
                user.setPassword(password);
                return "password updated";
            }
        }

        return "user : " + id + " not found";

       /* getAllUser()
                .stream()
                .filter(user->user.getUserId().equals(id))
                .forEach(user->{
                    user.setPassword(password);
                });*/
    }
}
