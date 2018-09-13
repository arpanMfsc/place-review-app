package com.reviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reviewapp.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	@Query("select avg(rating) from Comment where placeId=?1")
	double getAverageRating(long placeId);
	
	
}
