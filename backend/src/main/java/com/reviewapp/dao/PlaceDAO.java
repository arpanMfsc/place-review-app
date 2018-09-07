package com.reviewapp.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewapp.repositories.PlaceRepository;

public class PlaceDAO {
	@Autowired
	PlaceRepository places;
}
