package com.codeup.blogapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String hello(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String hello2(){
        return "posts/index";
    }
}
