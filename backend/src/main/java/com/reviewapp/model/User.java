package com.reviewapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

	private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) 
	Long userId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String phone;

	@Column(nullable = false)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date addedOn = new Date();

	@Column(nullable = false)
	private String type;

	private String dp;

	private String profession;

	private boolean activated = false;
	
	public User() {
	}

	// Copy constructor...
	public User(User u) {
		this.userName = u.getUserName();
		this.email = u.getEmail();
		this.phone = u.getPhone();
		this.password = u.getPassword();

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", addedOn=" + addedOn + ", type=" + type + ", dp=" + dp + ", profession="
				+ profession + ", activated=" + activated + "]";
	}

}
