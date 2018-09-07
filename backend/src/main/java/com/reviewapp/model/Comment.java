package com.reviewapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long commentId;
	private int rating=1;
	private String comment;
	
	@OneToOne
	private User addedBy;
	private String pictures;
}
