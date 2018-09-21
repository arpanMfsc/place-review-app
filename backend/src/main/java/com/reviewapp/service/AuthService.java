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
import com.reviewapp.dto.CustomUserFields;
import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;
import com.reviewapp.util.TokenUtil;
@Service
public class AuthService {

	// In memory token storage....
	private Map<String,Long> tokens = new HashMap<>();
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UserRepository users;

	/**
	 * This method is for checking if user is authenticated or not
	 * 
	 * @param HttpServletRequest request
	 * @return true if user is authenticated otherwise false
	 */
	public boolean isAuthenticated(String token) {
		return tokens.get(token)!=null;
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
	public CustomUserFields authenticate(HttpServletRequest request, String userId, String password) {
		
		// If user is already authenticated then no need to check...

		User user = users.findByEmailPasswordOrPhonePassword(userId, password);
		if(user==null) return null;
		CustomUserFields response = new CustomUserFields(user);
		System.out.println(response);

		String generatedToken = tokenUtil.generateToken(user.getUserId());
		tokens.put( generatedToken, user.getUserId() );
		response.setToken(generatedToken);

		return response;
	}

	/**
	 * This method will return the current user
	 * 
	 * @param HttpServletRequest request
	 * @return instance of User if authenticated otherwise null
	 */
	public User getUser(String token) {
		return users.findById( tokens.get(token) ).get();
	}
	/**
	 * This method will destroy the current session and logout user
	 * 
	 * @param HttpServletRequest request
	 */
	public void logout(String token) {
		tokens.remove(token);
	}

}
