package com.codeup.blogapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Post {
    private String title;
    private String body;
    private Post[] posts;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    @GetMapping("/posts/index")
    public Post[] viewAll(Model model){
        posts = new Post[2];
        posts[0] = new Post("Hello","This says Hello!");
        posts[1] = new Post("Goodbye","This says goodbye!");
        model.addAttribute("posts", posts);

        return posts;
    }

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title=title;}

    public String getBody(){return this.body;}
    public void setBody(String body){this.body=body;}
}
