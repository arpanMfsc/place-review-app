/***
 * This bean class is created for sending custom fields from user object as response....
 * The user object contains password or hashed password so we can't send
 * that to any request
 * @author arpanpathak
 *
 */
package com.reviewapp.requestresponsebean;

public class CustomUserFields {
	
	private Long userId;
	
	private String userName,dp;
	
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
	
}
