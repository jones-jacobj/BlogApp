package com.codeup.blogapp.Repositories;

import com.codeup.blogapp.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
    Extends JpaRepository, allows custom MYSQL database methods, with regard to posts;
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(Long id);
    Post searchByTitleLike(String title);
}
