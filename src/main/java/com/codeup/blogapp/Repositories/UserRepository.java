package com.codeup.blogapp.Repositories;

import com.codeup.blogapp.Models.Post;
import com.codeup.blogapp.Models.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
    Extends JpaRepository, allows custom MYSQL database methods, with regard to users;
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
}
