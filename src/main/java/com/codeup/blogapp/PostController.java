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

    @GetMapping("posts")
    public String getPosts(Model model){
        model.addAttribute("posts", this.postRepo.findAll());
        System.out.println("Intercepted /posts GET method");
        return "posts/index";
    }

    @GetMapping("posts/{id}")
    public String getPostNumber (Model model, @PathVariable long id){
        model.addAttribute("posts",this.postRepo.findById(id));
        return "posts/show";
    }

    @GetMapping("posts/create")
    public String createPost_GET(){
        return "posts/create";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String createPost_POST(@RequestParam(name="title") String title,
    @RequestParam(name="body") String body){
        Post p1 = new Post(title, body);
        postRepo.insert(p1);

        return("redirect:/posts/index");
    }
}
