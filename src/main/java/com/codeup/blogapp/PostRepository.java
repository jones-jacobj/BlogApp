package com.codeup.blogapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post a where a.id = ?1")
    Post getPostById(String title);
    @Query("from Post a where a.title like %:term%")
    Post searchByTitleLike(String title);
}