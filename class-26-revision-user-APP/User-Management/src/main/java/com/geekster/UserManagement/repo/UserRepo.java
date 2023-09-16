package com.geekster.UserManagement.repo;

import com.geekster.UserManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepo {

    @Autowired
    private List<User> usrList;

    public List<User> getUsrList() {
        return usrList;
    }
}
