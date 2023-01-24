package com.codeup.blogapp.Models;

import jakarta.persistence.*;

/*
    Class to represent the Posts users can create/ modify/ delete
 */
@Entity
@Table(name = "posts")
public class Post {

// ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

// TITLE
    @Column(nullable = false, length = 100)
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

// BODY
    @Column(nullable = false, length = 255)
    private String body;
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

// USER (OWNER)
    @OneToOne
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) { this.user = user; }


    public Post() {
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(Long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }
}
