package com.codeup.blogapp.Models;

import jakarta.persistence.*;

/*
    Class to represent the Posts users can create/ modify/ delete
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 100)
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false, length = 255)
    private String body;
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

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
