package com.reviewapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;


@Service
public class AuthService {
	
	@Autowired
	private UserRepository users;
	
	public boolean isAuthenticated(HttpServletRequest request) {
		return request.getAttribute("user")!=null;
	}
	
	public User authenticate(HttpServletRequest request,String userId,String password)
	{
		// If user is already authenticated then no need to check...
		if(request.getAttribute("user")!=null) 
			return (User) request.getAttribute("user");
		User user=users.findByEmailPasswordOrPhonePassword(userId, password);
		if(user!=null) {
			request.getSession(true)
				.setAttribute("user", user);
		}
		return user;
	}
	
	public User getUser(HttpServletRequest request) {
		return (User) request.getSession(false).getAttribute("user");
	}
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
}
