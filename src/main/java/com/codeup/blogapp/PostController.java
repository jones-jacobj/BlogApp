package com.codeup.blogapp;

import com.codeup.blogapp.Models.Post;
import com.codeup.blogapp.Models.User;
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

//
//      MAPPING: [GET] localhost:8080/posts
//       INTENT: Display ALL posts from MYSQL database
//

    @GetMapping("posts")
    public String getPosts(Model model) {
        model.addAttribute("posts", this.postRepo.findAll());
        System.out.println("Intercepted /posts GET method");
        return "posts/index";
    }

//
//      MAPPING: [GET] localhost:8080/posts/{number}
//       INTENT: Display a specific post from MYSQL database
//
    @GetMapping("posts/{id}")
    public String getPostNumber(Model model, @PathVariable long id) {
        model.addAttribute("posts", this.postRepo.findById(id));
        return "posts/show";
    }

//
//      MAPPING: [GET] localhost:8080/posts/create
//       INTENT: Intercept with java and direct to html- can be expanded; currently redundant
//

    @GetMapping("posts/create")
    public String createPost_GET() {
        return "posts/create";
    }


//
//      MAPPING: [POST] localhost:8080/posts/create
//       INTENT: Create a new Post and commit to MYSQL database
//
    @PostMapping("posts/create")
    public String createPost_POST(@RequestParam(name = "title") String title,
                                  @RequestParam(name = "body") String body,
                                  @RequestParam(name = "user") User user){

        postRepo.save(new Post(title, body, user));
        return ("redirect:/posts");
    }
}
