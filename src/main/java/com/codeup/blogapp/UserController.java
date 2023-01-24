package com.codeup.blogapp;

import org.springframework.web.bind.annotation.GetMapping;

/*
    Represents the users that can conncet to database & view, edit, or delete their posts
 */
public class UserController{
    private final UserController userRepo;

    public UserController(UserController userRepo){this.userRepo=userRepo;}

//
//      MAPPING: [GET] localhost:8080/login
//       INTENT: Intercept and direct user to login root
//
    @GetMapping("login")
    public String userPage(){
        return "/users/index";
    }
}
