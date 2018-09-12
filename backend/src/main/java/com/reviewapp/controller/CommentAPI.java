/***
 * This is the rest controller for handling all comment related operation
 */
package com.reviewapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;

@RestController
@RequestMapping("/comment")

public class CommentAPI {
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private PlaceRepository places;
	
	@Autowired
	private CommentRepository comments;
	
}
