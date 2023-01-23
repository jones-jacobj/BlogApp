package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles all functions and mapping dealing with posts | creating & viewing posts
 */
@Controller
public class PostController {
    private final PostRepository postRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(Model model){
        model.addAttribute("posts", this.postRepo.findAll());
        return "redirect:/localhost/posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostNumber(Model model, @PathVariable long id){
        model.addAttribute("posts",this.postRepo.findById(id));
        return "posts/show";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost_GET(){
        return "redirect:/posts/create";
    }

    @RequestMapping(path="/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost_POST(){
        return "You're on the create posts POST page!";
    }
}
