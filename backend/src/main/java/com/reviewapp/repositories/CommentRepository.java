package com.reviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reviewapp.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
