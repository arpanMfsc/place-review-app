package com.reviewapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewapp.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long>{

}
