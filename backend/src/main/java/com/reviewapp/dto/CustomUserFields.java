/***
 * This bean class is created for sending custom fields from user object as response....
 * The user object contains password or hashed password so we can't send
 * that to any request
 * @author arpanpathak
 *
 */
package com.reviewapp.dto;

import java.util.Date;

import com.reviewapp.model.User;

public class CustomUserFields {

	private Long 	userId;
	private String 	userName, dp;
	private String 	token;
	private String 	email;
	private String 	phone;
	private String 	profession;
	private	Date 	addedOn;
	private String 	type;
	public CustomUserFields(User user) {
		this.userId 	= user.getUserId();
		this.userName 	= user.getUserName();
		this.dp 		= user.getDp();
		this.email 		= user.getEmail();
		this.phone 		= user.getPhone();
		this.profession = user.getProfession();
		this.addedOn	= user.getAddedOn();
		this.type		= user.getType();
		System.out.println("Phone="+phone+",email="+email);
	}

	public CustomUserFields(Long userId, String userName, String dp) {
		this.userId = userId;
		this.userName = userName;
		this.dp = dp;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getDp() {
		return dp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDp(String dp) {
		this.dp = dp;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CustomUserFields [userId=" + userId + ", userName=" + userName + ", dp=" + dp + ", token=" + token
				+ ", email=" + email + ", phone=" + phone + ", profession=" + profession + ", addedOn=" + addedOn + "]";
	}
	

}
