package com.reviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reviewapp.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{
	@Query("select avg(rating) from Comment")
	double getAverageRating(Long placeId);
	
	
}
