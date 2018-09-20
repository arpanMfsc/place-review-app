package com.reviewapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewapp.model.Place;
import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;

public class PlaceService {
	
	@Autowired
	PlaceRepository places;
	
	@Autowired
	CommentRepository comments;
	
	List<Place> getAllPlaces() {
		return places.findAll();
	}
	
}
