package com.codeup.blogapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post a where a.id = ?1")
    Post getPostById(Long id);

//    @Query("from Post a where a.title like %:term%")
    Post searchByTitleLike(String title);

    @Query(value="insert into posts (title, body) values a.title, a.body", nativeQuery = true)
    void insert(Post post);
}
