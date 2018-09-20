/***
 * Authentication Service
 * @author arpanpathak
 *
 */
package com.reviewapp.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;

@Service
public class AuthService {

	private Map<String,User> tokens = new HashMap<>();
	
	@Autowired
	private UserRepository users;

	/**
	 * This method is for checking if user is authenticated or not
	 * 
	 * @param HttpServletRequest request
	 * @return true if user is authenticated otherwise false
	 */
	public boolean isAuthenticated(HttpServletRequest request) {
		return request.getSession().getAttribute("user") != null;
	}

	/**
	 * This method is used to authenticate a user given email or phone and password
	 * 
	 * @param HttpServletRequest request
	 * @param String             userId ( just pass the phoneNo or email of user
	 *                           here )
	 * @param String             password
	 * @return instance of User if successfully authenticated otherwise null
	 */
	public User authenticate(HttpServletRequest request, String userId, String password) {
		// If user is already authenticated then no need to check...
		if (request.getAttribute("user") != null)
			return (User) request.getAttribute("user");
		User user = users.findByEmailPasswordOrPhonePassword(userId, password);
		if (user != null) {
			request.getSession(true).setAttribute("user", user);
		}
		System.out.println(user);
		return user;
	}

	/**
	 * This method will return the current user
	 * 
	 * @param HttpServletRequest request
	 * @return instance of User if authenticated otherwise null
	 */
	public User getUser(HttpServletRequest request) {
		return (User) request.getSession(false).getAttribute("user");
	}

	/**
	 * This method will destroy the current session and logout user
	 * 
	 * @param HttpServletRequest request
	 */
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}

}
