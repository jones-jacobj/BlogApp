
DROP DATABASE IF EXISTS post_db;

CREATE DATABASE post_db;

USE post_db;

DROP TABLE IF EXISTS posts;

CREATE TABLE IF NOT EXISTS posts (
                                     id INT AUTO_INCREMENT NOT NULL,
                                     name VARCHAR(50),
                                     email VARCHAR(50),
                                     PRIMARY KEY (id)
);

create user post_moderator@post_db
    identified by 'password1';

grant alter, create, create view, delete, drop, index, insert, select, update on post_db.* to post_moderator@post_db;

