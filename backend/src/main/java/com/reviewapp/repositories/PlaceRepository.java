package com.reviewapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reviewapp.model.Place;
import com.reviewapp.model.User;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	/**
	 * This method will return the average rating for a place
	 * @param long placeId
	 * @return Double averageRating
	 */
	@Query("select avg(comment.rating) from Comment comment where placeId=?1")
	Double getAverageRating(long placeId);

	/**
	 * This method will search places
	 * @param String searchParameter
	 * @return List<Place> List of matched places
	 */
	@Query("select p from Place p where p.name LIKE %?1% ")
	List<Place> searchPlace(String searchParameter);
	
	/**
	 * This method will return 
	 * @param long addedBy
	 * @return List<Place> List of places added by user
	 */
	@Query("select p from Place p where p.addedBy=?1")
	List<Place> getPlacesAddedBy(long addedBy);
}
