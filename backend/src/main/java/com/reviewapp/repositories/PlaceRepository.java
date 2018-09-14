package com.reviewapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reviewapp.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	// get the average rating
	@Query("select avg(comment.rating) from Comment comment where placeId=?1")
	Double getAverageRating(long placeId);

	// search places
	@Query("select p from Place p where p.name like '%?1%'")
	List<Place> searchPlace(String searchParameter);
}
