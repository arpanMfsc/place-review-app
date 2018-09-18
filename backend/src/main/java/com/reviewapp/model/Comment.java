package com.reviewapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  Long commentId;
	
	private Long placeId;
	
	private double rating;
	
	private String comment;
	
	@OneToOne
	private User addedBy;
	
	@OneToMany
	private List<Picture> pictures= new ArrayList<>();
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", placeId=" + placeId + ", rating=" + rating + ", comment="
				+ comment + ", addedBy=" + addedBy + ", pictures=" + pictures + "]";
	}
	
}
