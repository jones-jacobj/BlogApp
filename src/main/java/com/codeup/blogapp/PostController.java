package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Handles all functions and mapping dealing with post, posting, viewing posts
 */
@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(){
        return "You're on the Posts page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostNumber(@PathVariable int id){
        return "You're on the posts page for post #" + id + "!";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost_GET(){
        return "You're on the create posts GET page!";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost_POST(){
        return "You're on the create posts POST page!";
    }
}
