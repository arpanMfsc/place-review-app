package com.reviewapp.requestresponsebean;

import java.util.Date;

import com.reviewapp.model.Place;
import com.reviewapp.model.User;

public class PlaceResponse {
	private Long 				placeId;
	private String 				name;
	private String				description;
	private String				address;
	private Date				addedOn;
	private CustomUserFields 	addedBy;
	private double 				rating;
	
	public PlaceResponse(Place p,User u,double rating) {
		
		placeId 	=	p.getPlaceId();
		name		=	p.getName();
		description =	p.getDescription();
		address		=	p.getDescription();
		addedOn		=	p.getAddedOn();
		addedBy		= 	new CustomUserFields(u.getUserId(),u.getUserName(),u.getDp());
		this.rating = 	rating;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getAddress() {
		return address;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public CustomUserFields getAddedBy() {
		return addedBy;
	}

	public double getRating() {
		return rating;
	}
	
	
	
}
