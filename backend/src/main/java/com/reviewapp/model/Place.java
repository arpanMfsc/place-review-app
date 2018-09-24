/***
 * Place Model Class
 * @author arpanpathak
 */
package com.reviewapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@Entity
@Table(name="places")
public class Place {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long 			placeId;
	private String 			name;
	
	@Column(columnDefinition="TEXT")
	private String			description;
	
	private String			address;
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true,
	        fetch=FetchType.LAZY
	    )
	@JoinColumn
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Picture>  	pictures = new ArrayList<>();
	
	@OneToMany(
	        cascade = CascadeType.ALL, 
	        
	        fetch=FetchType.LAZY,
	        targetEntity=Comment.class
	    )
	@JoinColumn
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Comment>	comments ;
	
	private Long addedBy;
	
	private Date addedOn=new Date();

	/** GETTERS AND SETTERS **/
	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String location) {
		this.address = location;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Long getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Long addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
