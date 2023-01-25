package com.codeup.blogapp.Controllers;

import com.codeup.blogapp.Models.User;
import com.codeup.blogapp.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
    Represents the users that can connect to database & view, edit, or delete their posts
 */
@Controller
public class UserController{
    private final UserRepository userRepo;

    public UserController(UserRepository userRepo){
        this.userRepo=userRepo;
    }

//
//      MAPPING: [GET] localhost:8080/login
//       INTENT: Intercept and direct user to login root
//
    @GetMapping("login")
    public String userPage(){
        return "login";
    }


//
//      MAPPING: [GET] localhost:8080/register
//       INTENT: Check to see if user is already logged in, otherwise allow registering new User
//
    @GetMapping("register")
    public String checkRegister(){
        //TODO: Check to see if logged in
        return "users/register";
    }

//
//      MAPPING: [POST] localhost:8080/register
//       INTENT: Handle validating submitted info & logging in a user
//

    @PostMapping("users/register")
    public String doLogin(@RequestParam(name = "user") String username,
                          @RequestParam(name = "pass") String password,
                          @RequestParam(name = "pass2") String password2,
                          @RequestParam(name = "email") String email){
        System.out.println("Received attempted to create user");
        if (password.equals(password2)){
            System.out.println("Passwords match");
            userRepo.save(new User(username, password, email));
            return ("redirect:/users/index");
        }else{
            System.out.println("ERROR:> Passwords need to match");
            return "users/register";
        }
    }
}
