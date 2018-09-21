package com.reviewapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.reviewapp.model.Place;
import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;

public class PlaceService {
	
	@Autowired
	UserRepository users;
	
	@Autowired
	PlaceRepository places;
	
	@Autowired
	CommentRepository comments;
	
	List<Place> getAllPlaces() {
		return places.findAll();
	}
	
	boolean deletePlace (long placeId) {
		try {
			places.deleteById(placeId);
		}catch(Exception e) {
			return false;
		}
		//returning true if no exception occurs ..
		return true;
	}
	
}
