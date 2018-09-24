package com.reviewapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="drafts")
public class Draft {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long draftId;
	private Long userId;
	
	private String name,description,address;
	
}
