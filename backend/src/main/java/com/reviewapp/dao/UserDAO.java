
package com.reviewapp.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewapp.repositories.UserRepository;

public class UserDAO {

	@Autowired
	private UserRepository userRepo;
}
