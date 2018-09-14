/***
 * Place REST CONTROLLER
 * @author arpanpathak
 */
package com.reviewapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reviewapp.model.Comment;
import com.reviewapp.model.Place;
import com.reviewapp.model.User;
import com.reviewapp.repositories.CommentRepository;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;
import com.reviewapp.requestresponsebean.PlaceResponse;

@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "*")
public class PlaceAPI {

	@Autowired
	private PlaceRepository places;

	@Autowired
	private UserRepository users;

	@Autowired
	private CommentRepository comments;

	/**
	 * This API route will return all the places
	 * 
	 * @return List<Place> list of places
	 */
	@GetMapping("/get-all-places")
	public List<PlaceResponse> getAllPlaces() {

		List<PlaceResponse> response = new ArrayList<>();

		for (Place place : places.findAll()) {

			User u = users.findById(place.getAddedBy()).get();
			System.out.println(place.getComments());
			System.out.println(places.getAverageRating(place.getPlaceId()));
			response.add(new PlaceResponse(place, u, 2.0));
		}
		return response;
	}

	/**
	 * 
	 * This API route will add a new comment to a post
	 * 
	 * @param Comment comment
	 * @return instance of comment if comment is added successfully
	 */
	@PostMapping("/add-comment")
	public Comment addComment(@RequestBody Comment comment) {
		Comment c = new Comment();
		c.setPlaceId(comment.getPlaceId());
		c.setAddedBy(users.findById(comment.getAddedBy().getUserId()).get());
		c.setComment(comment.getComment());
		c.setRating(c.getRating());
		System.out.println(c);
		Place p = places.findById(c.getPlaceId()).get();

		p.getComments().add(c);
		places.save(p);
		return c;
	}

	/**
	 * This API route will delete all the places
	 * 
	 * @return String
	 */
	@GetMapping("/delete-all-places")
	public String deleteAllPlaces() {

		places.deleteAll();
		return "Deleted";

	}

	/**
	 * This API route will return average rating for a place
	 * 
	 * @param Long id
	 * @return average rating
	 */
	@GetMapping("/get-rating/{id}")
	public double getRating(@PathVariable("id") Long id) {

		return places.getAverageRating(id);
	}
	
}
