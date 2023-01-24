package com.codeup.blogapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post a where a.id = ?1")
    Post getPostById(Long id);
    Post searchByTitleLike(String title);
}
