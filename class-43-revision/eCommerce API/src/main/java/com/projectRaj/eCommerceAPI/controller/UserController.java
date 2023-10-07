package com.projectRaj.eCommerceAPI.controller;

import com.projectRaj.eCommerceAPI.models.User;
import com.projectRaj.eCommerceAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{
    @Autowired
    UserService userService;

    @PostMapping("api/users")
    public String createUsers(@Valid @RequestBody List<User> users) {
        return userService.createUsers(users);
    }

}
