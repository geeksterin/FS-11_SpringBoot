package com.geekster.InstaBackend.controller;


import com.geekster.InstaBackend.model.*;

import com.geekster.InstaBackend.service.AuthenticationService;
import com.geekster.InstaBackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User newUser)
    {

        return userService.userSignUp(newUser);
    }



    //sign in
    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email,@PathVariable String password)
    {
        return userService.userSignIn(email,password);
    }


    //sign out
    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestParam String email, @RequestParam String token)
    {
        return userService.userSignOut(email,token);
    }



    @PostMapping("InstaPost")
    public String createInstaPost(@RequestParam String email,@RequestParam String tokenValue, @RequestBody Post instaPost)
    {
        return userService.createInstaPost(email,tokenValue,instaPost);
    }


    @DeleteMapping("InstaPost/{postId}")
    public String deleteInstaPost(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer postId)
    {
        return userService.deleteInstaPost(email,tokenValue,postId);
    }


    //like apis
    @PostMapping("like/post/{postId}")
    public String addLike(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer postId)
    {
        return userService.addLike(email,tokenValue,postId);
    }


    @DeleteMapping("unlike/post/{postId}")
    public String removeLike(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer postId)
    {
        return userService.removeLike(email,tokenValue,postId);
    }


    @GetMapping("count/likes/post/{postId}")
    public String getLikesByPostId(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer postId)
    {
        return userService.getLikesByPostId(email,tokenValue,postId);
    }

    //comment apis


    @PostMapping("comment/post/{postId}")
    public String addComment(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer postId,@RequestBody String commentBody )
    {
        return userService.addComment(email,tokenValue,commentBody,postId);
    }


    @DeleteMapping("post/comment/{commentId}")
    public String removeComment(@RequestParam String email, @RequestParam String tokenValue,
                                @PathVariable Integer commentId)
    {
        return userService.removeComment(email,tokenValue,commentId);
    }



    @PostMapping("follow/user/{targetUserId}")
    public String followTarget(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Integer targetUserId)
    {
        return userService.followTarget(email,tokenValue,targetUserId);
    }






























}


