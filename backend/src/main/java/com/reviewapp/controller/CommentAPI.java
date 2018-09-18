/***
 * This is the rest controller for handling all comment related operation
 */
package com.reviewapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewapp.model.Comment;
import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*") // allow all the origins for API calls
@RequestMapping("/comment")

public class CommentAPI {
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private PlaceRepository places;
	
	@Autowired
	private CommentRepository comments;
	
	/**
	 * THIS WILL NOT WORK BECAUSE THERE IS A FOREIGN KEY RELATIONSHIP
	 * @return
	 */
	@GetMapping("/delete-all")
	public String deleteAll() {
		comments.deleteAll();
		return "Deleted";
	}
	
	/**
	 * This method will delete a comment
	 * @param Comment comment ( commentId must be set, other properties can be null
	 * @return a Map<String,String> containing message
	 */
	@PostMapping("/delete-comment")
	public Map<String,String> deleteComment(@RequestBody Comment comment) {
		Map<String,String> response = new HashMap<>();
		comments.deleteById(comment.getCommentId());
		response.put("success", "deleted");
		return response;
	}
	
}
