package com.reviewapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Place> getAllPlaces() {
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
		List<PlaceResponse> foundPlaces = new ArrayList<>();
		
		for(Place place : places.searchPlace(text.toLowerCase()) ) {
			Double rating=places.getAverageRating(place.getPlaceId());
			foundPlaces.add( 
			 new PlaceResponse(
					place,
					users.findById(place.getAddedBy()).get(),
					rating==null?0:rating
					
			 )
			);
		}
		// return sorted data based on rating....
		return foundPlaces.stream()
				.sorted((p1,p2)-> (int)p2.getRating()-(int)p1.getRating() )
				.collect(Collectors.toList());
	}
	
	public Place saveInDraft(Place place) {
		
		return null;
	}
	
}
