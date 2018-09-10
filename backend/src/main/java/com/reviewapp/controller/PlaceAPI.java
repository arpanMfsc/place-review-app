package com.reviewapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.reviewapp.model.*;
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
}
