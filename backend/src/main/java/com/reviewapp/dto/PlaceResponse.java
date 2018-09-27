/***
 * Custom PlaceResponse Class which includes calculated rating
 * @author arpanpathak
 */
package com.reviewapp.dto;

import java.util.Date;
import java.util.List;

import com.reviewapp.model.Comment;
import com.reviewapp.model.Picture;
import com.reviewapp.model.Place;
import com.reviewapp.model.User;

public class PlaceResponse {
	private Long 				placeId;
	private String 				name;
	private String				description;
	private String				address;
	private String				addedOn;
	private CustomUserFields 	addedBy;
	private double 				rating;
	private List<Comment>		comments;
	private List<Picture>		pictures;
	
	public PlaceResponse(Place p,User u,double rating) {
		
		placeId 	=	p.getPlaceId();
		name		=	p.getName();
		description =	p.getDescription();
		address		=	p.getAddress();
		addedOn		=	p.getAddedOn().toLocaleString();
		addedBy		= 	new CustomUserFields(u.getUserId(),u.getUserName(),u.getDp());
		setComments(p.getComments());
		pictures	=	p.getPictures();
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

	public String getAddedOn() {
		return addedOn;
	}

	public CustomUserFields getAddedBy() {
		return addedBy;
	}

	public double getRating() {
		return rating;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
