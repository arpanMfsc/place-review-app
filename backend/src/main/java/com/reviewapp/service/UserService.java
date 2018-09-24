package com.reviewapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository users;
	@Autowired
	private FileService fileService;
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
	
	/**
	 * This method finds a single user by email-id
	 * @param email
	 * @return instance of User if found otherwise null
	 */
	public User findByEmail(String email) {
		return users.findByEmail(email);
	}
	
	/**
	 * This method finds a single user by phone-no
	 * @param phone
	 * @return instance of User if found otherwise null
	 */
	public User findByPhone(String phone) {
		return users.findByPhone(phone);
	}
	
	/**
	 * This method deletes all user
	 */
	public void deleteAll() {
		users.deleteAll();
	}
	
	public User changeDp(long userId,MultipartFile file) throws Exception {
		User user = users.findById(userId).get();
		String uploadedFileName = fileService.uploadFile(file);
		user.setDp(uploadedFileName);
		return users.save(user);	
	}
}
