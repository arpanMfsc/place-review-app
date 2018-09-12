package com.reviewapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewapp.model.Comment;
import com.reviewapp.model.Place;
import com.reviewapp.repositories.PlaceRepository;
@RestController
@RequestMapping("/place")
public class PlaceAPI {
	@Autowired
	private PlaceRepository places;
	@GetMapping("/getAllPlaces")
	public List<Place> getAllPlaces(){
		return places.findAll();
	}
	
	@PostMapping("/add-comment")
	public Comment addComment(Comment comment) {
		Place place = places.findById( comment.getPlaceId()).get();
		
		
	}
}
