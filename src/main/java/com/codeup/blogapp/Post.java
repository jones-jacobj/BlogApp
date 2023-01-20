package com.codeup.blogapp;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 255)
    private String body;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post() {

    }
}
