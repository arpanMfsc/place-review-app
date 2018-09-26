package com.reviewapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewapp.model.Draft;

public interface DraftRepository extends JpaRepository<Draft, Long> {
	List<Draft> findByUserId(long userId);
}
