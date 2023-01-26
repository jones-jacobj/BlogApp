package com.codeup.blogapp.Controllers;

import com.codeup.blogapp.Models.Post;
import com.codeup.blogapp.Repositories.PostRepository;
import com.codeup.blogapp.Repositories.UserRepository;
import com.codeup.blogapp.Services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles all functions and mapping dealing with posts | creating & viewing posts
 */
@Controller
public class PostController {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo){
        this.postRepo = postRepo;
        this.userRepo = userRepo;
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
                                  @CookieValue(value="name", defaultValue = "") String user
                                  ){
        if(user != null) {
            Post p1 = new Post();
            p1.setUser(this.userRepo.findUserByUsername(user));
            p1.setTitle(title);
            p1.setBody(body);
            postRepo.save(p1);
            return ("redirect:/posts");
        }else{
            return ("redirect:/login");
        }
        }
}
