/***
 * User REST CONTROLLER
 * @author arpanpathak
 */
package com.reviewapp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reviewapp.model.User;
import com.reviewapp.repositories.UserRepository;
import com.reviewapp.requestresponsebean.LoginRequest;
import com.reviewapp.service.*;

@RestController
@CrossOrigin(origins = "*") // allow all the origins for API calls
@RequestMapping("/api")

public class UserAPI {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AuthService auth;

	/**
	 * A rest API route for creating user...
	 * 
	 * @param User u
	 * @return User object if successfully created
	 */
	@PostMapping("/createUser")
	public User returnCreatedUser(@RequestBody User u) {
		return userRepo.save(u);
	}

	/**
	 * A rest API route for getting list of users
	 * 
	 * @param r
	 * @return List of User
	 */
	@GetMapping("/get-all-users")
	public List<User> getAllUsers(HttpServletRequest r) {
		System.out.println(r.getSession());
		return userRepo.findAll();
	}

	/**
	 * This API route will delete all the users
	 * 
	 * @return String
	 */
	@GetMapping("/delete-all")
	public String deleteAll() {
		userRepo.deleteAll();
		return "deleted all users";
	}

	/**
	 * A rest api route that returns List of users...
	 * 
	 * @param name
	 * @return List<User> list of users by name
	 */
	@GetMapping("/find/{name}")
	public List<User> findByName(@PathVariable("name") String name) {
		return userRepo.findByUserName(name);

	}

	/**
	 * This method will check if the given email already being used or not
	 * 
	 * @param email
	 * @return true if email email address is available to use otherwise false
	 */
	@PostMapping("/find-by-email")
	public boolean checkEmailAvailable(@RequestBody String email) {
		User u = userRepo.findByEmail(email);
		System.out.println(u);
		return u == null;
	}

	/**
	 * This API route will check if the phone no is already being used or not
	 * 
	 * @param String phone
	 * @return true if the given phone no is available otherwise false
	 */
	@PostMapping("/find-by-phone")
	public boolean checkPhoneAvailable(@RequestBody String phone) {
		System.out.println(userRepo.findByPhone(phone));
		return userRepo.findByPhone(phone) == null;
	}

	/**
	 * This API route will authenticate the user based on given credentials
	 * 
	 * @param HttpServlet  request
	 * @param LoginRequest credentials
	 * @return an instance of User if successfully logged in otherwise null
	 */
	@PostMapping("/login")
	public User login(HttpServletRequest request, @RequestBody LoginRequest credentials) {
		return auth.authenticate(request, credentials.userId, credentials.password);
	}

	/**
	 * This API route is used to check if the user is authenticated or not
	 * 
	 * @param HttpServlet request
	 * @return an instance of User if authenticated otherwise false
	 */
	@GetMapping("/is-authenticated")
	public User isAuthenticated(HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("user"));
		return (User) request.getSession(false).getAttribute("user");
	}

}
