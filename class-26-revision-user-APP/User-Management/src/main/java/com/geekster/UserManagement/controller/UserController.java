package com.geekster.UserManagement.controller;


import com.geekster.UserManagement.entity.User;
import com.geekster.UserManagement.repo.PasswordChanger;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("users")
    public List<User> getAllUser()
    {
      return  userService.getAllUser();
    }


    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User> myUsers)
    {
        return  userService.addUsers(myUsers);
    }

    //update password of the user

    @PutMapping("user/password")
    public String updatePasswordByUserId(@RequestBody @Valid PasswordChanger passwordChanger)
    {
        return  userService.updatePasswordByUserId(passwordChanger.getId(),passwordChanger.getPassword());
    }



}
