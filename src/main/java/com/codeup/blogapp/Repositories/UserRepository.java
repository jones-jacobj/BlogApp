package com.codeup.blogapp.Repositories;

import com.codeup.blogapp.Models.Post;
import com.codeup.blogapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Extends JpaRepository, allows custom MYSQL database methods, with regard to users;
 */
public interface UserRepository extends JpaRepository<User, Long> {
//    User getUserById(Long id);
//    User searchUserByName(String title);
}
