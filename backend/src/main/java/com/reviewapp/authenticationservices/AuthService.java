package com.reviewapp.authenticationservices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;
public class AuthService {
	
	@Autowired
	private static UserRepository users;
	static boolean isAuthenticated(HttpServletRequest request) {
		return request.getAttribute("user")!=null;
	}
	static boolean authenticate(HttpServletRequest request,String userId,String password)
	{
		// If user is already authenticated then no need to check...
		if(request.getAttribute("user")!=null) 
			return true;
		User user=users.findByEmailPasswordOrPhonePassword(userId, password);
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return true;
		}
		return false;
	}
	
}
