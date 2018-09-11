package com.reviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

}
