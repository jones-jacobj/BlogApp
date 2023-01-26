package com.codeup.blogapp.Services;

import com.codeup.blogapp.Models.Post;
import com.codeup.blogapp.Models.User;

public class EmailService {

    public EmailService(){

    }

    public void alertMessage(){
        // If user post a message or someone comments on their message
        // Get user
        User currentUser = new User("emailServiceUserTesting","emailServiceUserTesting","emailServiceUserTesting");
        // Get user's email
        String email = currentUser.getEmail();
        // Send pregenerated email
        Post currentPost = new Post("emailServicePostTesting","emailServicePostTesting", currentUser);
        String message = String.format("You have successfully created post titled %s!", currentPost.getTitle());
    }
}
