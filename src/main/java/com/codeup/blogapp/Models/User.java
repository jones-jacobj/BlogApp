package com.codeup.blogapp.Models;

import jakarta.persistence.*;

import java.util.List;

/*
    Class to represent the users that can Post to the blog
 */
@Entity
public class User {

// ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

// USERNAME
    @Column(nullable=false, length=20)
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

// PASSWORD
    @Column(nullable = false, length = 20)
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

// EMAIL
    @Column(nullable = false, length = 40)
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

// POSTS
    @OneToMany
    private List<Post> posts;
    public void addPost(Post post){this.posts.add(post);}
    public void setPosts(List<Post> posts){this.posts = posts;}
    public List<Post> getPosts(){return this.posts;}

    public User() {

    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
