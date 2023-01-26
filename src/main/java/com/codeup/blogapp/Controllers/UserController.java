package com.codeup.blogapp.Controllers;

import com.codeup.blogapp.Models.User;
import com.codeup.blogapp.Repositories.UserRepository;
import jakarta.servlet.http.Cookie;
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
//    public static boolean isLoggedIn = false;

    public UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

//
//      MAPPING: [GET] localhost:8080/login
//       INTENT: Intercept and direct user to login root
//
    @GetMapping("login")
    public String userPage(){
        return "users/login";
    }

    //
    //      MAPPING: [POST] localhost:8080/login
    //       INTENT: Handle login, verify username & password, toggle 'loggedIn' static value
    //

    @PostMapping("login")
    public String userPage2(
            @RequestParam(name = "user") String username,
            @RequestParam(name = "pass") String password){

        User user = this.userRepo.findUserByUsernameAndPassword(username, password);
        System.out.println(user);
        if (user != null){
            System.out.printf("User %s succesfully logged in",user.getUsername());
            Cookie cookie = new Cookie("username",user.getUsername());


            return "redirect:posts/create";
        }

        return "redirect:login";

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
    public String doRegistration(@RequestParam(name = "user") String username,
                                 @RequestParam(name = "pass") String password,
                                 @RequestParam(name = "pass2") String password2,// For validation only
                                 @RequestParam(name = "email") String email){
        if (password.equals(password2)){
            System.out.println("Passwords match");
            userRepo.save(new User(username, password, email));

//            isLoggedIn = true;
            return ("redirect:/");
        }else{
            System.out.println("ERROR:> Passwords need to match");
            return "users/register";
        }
    }
}
