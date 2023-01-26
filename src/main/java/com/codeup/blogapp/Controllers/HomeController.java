package com.codeup.blogapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String hello(@CookieValue(value="name",  defaultValue = "") String username){
        if (username != null) {
            return "redirect:home";
        }else{
            return "redirect:login:";
        }
    }

    @GetMapping("/home")
    public String hello2(){
        return "posts/index";
    }
}
