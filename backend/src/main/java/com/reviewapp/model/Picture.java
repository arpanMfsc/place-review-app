package com.reviewapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pictures")
public class Picture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long pictureId;
	
	private String fileName;
	
	private String description;
	
	public Picture() { }
	
	public Long getPictureId() {
		return pictureId;
	}
	
	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Picture(String fileName, String description) {
		super();
		this.fileName = fileName;
		this.description = description;
	}
	
}
