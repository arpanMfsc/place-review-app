package com.reviewapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository users;
	
	/**
	 * add user
	 * @param User user
	 * @return instance of added User
	 */
	public User addUser(User user) {
		if(user.getDp()==null)
			user.setDp("default.jpg");
		return users.save(user);
	}
	
	public User findByEmail(String email) {
		return users.findByEmail(email);
	}
	
	public User findByPhone(String phone) {
		return users.findByPhone(phone);
	}
	
}
