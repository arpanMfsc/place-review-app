package com.reviewapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewapp.repositories.CommentRepository;

public class CommentService {
	@Autowired
	CommentRepository comments;
	
}
