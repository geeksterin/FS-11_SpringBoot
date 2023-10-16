package com.geekster.InstaBackend.service;



import com.geekster.InstaBackend.model.*;

import com.geekster.InstaBackend.repository.IUserRepo;

import com.geekster.InstaBackend.service.emailUtility.EmailHandler;
import com.geekster.InstaBackend.service.hashingUtility.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    LikeService likeService;

    @Autowired
    FollowService followService;


    public String userSignUp(User newUser) {

        //check if already exist -> Not allowed : try logging in

        String newEmail = newUser.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            return "email already in use";
        }

        // passwords are encrypted before we store it in the table

        String signUpPassword = newUser.getUserPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            newUser.setUserPassword(encryptedPassword);


            // patient table - save patient
            userRepo.save(newUser);
            return "Insta user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }


    public String userSignIn(String email, String password) {

        //check if the email is there in your tables
        //sign in only possible if this person ever signed up


        User existingUser = userRepo.findFirstByUserEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                // return a token for this sign in
                AuthenticationToken token  = new AuthenticationToken(existingUser);

                if(EmailHandler.sendEmail(email,"otp after login", token.getTokenValue())) {
                    authenticationService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }

            }
            else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignOut(String email,String tokenValue) {
        if(authenticationService.authenticate(email,tokenValue)) {
            authenticationService.deleteToken(tokenValue);
            return "Sign Out successful!!";
        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String createInstaPost(String email, String tokenValue, Post instaPost) {

        if(authenticationService.authenticate(email,tokenValue)) {

            User existingUser = userRepo.findFirstByUserEmail(email);
            instaPost.setPostOwner(existingUser);




            postService.createInstaPost(instaPost);
            return instaPost.getPostType() + " posted!!";

        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String deleteInstaPost(String email, String tokenValue, Integer postId) {

        if(authenticationService.authenticate(email,tokenValue)) {

         Post instaPost =  postService.getPostById(postId);
         String  postOwnerEmail =  instaPost.getPostOwner().getUserEmail();

         if(email.equals(postOwnerEmail))
         {


             //finally delete the insta post
             postService.removeById(postId);
             return "post removed!!";

         }
         else {
             return "Un authorized access!!";
         }


        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String addLike(String email, String tokenValue, Integer postId) {

        if(authenticationService.authenticate(email,tokenValue)) {

            //figure out the post which we are liking
            Post instaPostToBeLiked = postService.getPostById(postId);

            //we have to figure out the liker
            User liker = userRepo.findFirstByUserEmail(email);

            // user cannot like this particular postId more than once

            boolean alreadyLiked = likeService.isAlreadyLiked(instaPostToBeLiked,liker);

            if(!alreadyLiked) {
                Like newLike = new Like(null, instaPostToBeLiked, liker);

                likeService.addLike(newLike);

                return liker.getUserHandle() + " liked " +  postId;
            }
            else {
                return "already liked";
            }
        }
        else {
            return "Un Authenticated access!!!";
        }
    }


    public String removeLike(String email, String tokenValue, Integer postId) {

        if(authenticationService.authenticate(email,tokenValue)) {

            User potentialLiker = userRepo.findFirstByUserEmail(email);

            Post instaPostToBeUnLiked = postService.getPostById(postId);

           return likeService.removeLikesByLikerAndPost(potentialLiker,instaPostToBeUnLiked);

        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String getLikesByPostId(String email, String tokenValue, Integer postId) {

        if(authenticationService.authenticate(email,tokenValue)) {

            Post instaPost = postService.getPostById(postId);

           return likeService.getLikesForPost(instaPost);

        }
        else {
            return "Un Authenticated access!!!";
        }
    }

    public String addComment(String email, String tokenValue, String commentBody,Integer postId) {

        if(authenticationService.authenticate(email,tokenValue)) {

            //figure out the post which we are commenting
            Post instaPostToBeCommented = postService.getPostById(postId);

            //we have to figure out the commentor
            User commentor = userRepo.findFirstByUserEmail(email);

            // functionally more than 1 comment can be made on a particular post

            Comment newComment = new Comment(null,commentBody,
                    LocalDateTime.now(), instaPostToBeCommented, commentor);

            commentService.addComment(newComment);

            return commentor.getUserHandle() + " commented on " + postId;


        }
        else {
            return "Un Authenticated access!!!";
        }
    }



    public String removeComment(String email, String tokenValue, Integer commentId) {

        if(authenticationService.authenticate(email,tokenValue)) {
            Comment comment = commentService.findCommentById(commentId);

            Post instaPostOfComment = comment.getInstaPost();


           if(authorizeCommentRemover(email,instaPostOfComment,comment))
           {
               commentService.removeCommentById(commentId);
               return "comment deleted";
           }
           else {
               return "Not authorized!!";
           }

        }
        else {
            return "Un Authenticated access!!!";
        }

    }

    private boolean authorizeCommentRemover(String email,Post instaPostOfComment, Comment comment) {

        User potentialRemover = userRepo.findFirstByUserEmail(email);

        //only the commentor and the owner of the post should be allowed to remove a comment

        return potentialRemover.equals(instaPostOfComment.getPostOwner()) || potentialRemover.equals(comment.getCommenter());

    }


    public String followTarget(String email, String tokenValue, Integer targetUserId) {

        if(authenticationService.authenticate(email,tokenValue)) {

          User follower = userRepo.findFirstByUserEmail(email);
          User target = userRepo.findById(targetUserId).orElseThrow();

          if(authorizeToFollow(follower,target))
          {
              followService.startFollowing(follower,target);
              return follower.getUserHandle() + " started following " + target.getUserHandle();
          }
          else {
              return "Already follows, cannot re-follow";
          }

        }
        else {
            return "Un Authenticated access!!!";
        }

    }

    private boolean authorizeToFollow(User follower, User target) {

        //check if already follows or not

        boolean followingExist =  followService.findByTargetAndFollower(follower,target);

        return !followingExist && !follower.equals(target);

    }
}
