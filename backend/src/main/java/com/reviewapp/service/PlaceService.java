package com.reviewapp.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewapp.dto.PlaceResponse;
import com.reviewapp.model.Place;
import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;

@Service
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
	
	public boolean deletePlace (long placeId) {
		try {
			places.deleteById(placeId);
		}catch(Exception e) {
			return false;
		}
		//returning true if no exception occurs ..
		return true;
	}
	
	public List<PlaceResponse> searchPlace(String text) {
		List<PlaceResponse> foundPlaces = new LinkedList<>();
		
		for(Place place : places.searchPlace(text.toLowerCase()) ) {
			foundPlaces.add( 
			 new PlaceResponse(
					place,
					users.findById(place.getAddedBy()).get(),
					places.getAverageRating(place.getPlaceId())
			 )
			);
		}
		return foundPlaces;
	}
	
}
