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

import com.reviewapp.model.Place;
import com.reviewapp.model.User;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;
import com.reviewapp.requestresponsebean.LoginRequest;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserAPI {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PlaceRepository placeRepo;
	/**
	 * A rest API route for creating user...
	 * @param u
	 * @return user object if succesfully created
	 */
	@PostMapping("/createUser")
	public User returnCreatedUser(@RequestBody User u) {
		return userRepo.save(u);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(HttpServletRequest r) {
		System.out.println(r.getSession());
		return userRepo.findAll();
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll() {
		userRepo.deleteAll();
		return "deleted all users";
	}
	/**
	 * A rest api route that returns List of users...
	 * @param name
	 * @return List<User> list of users by name
	 */
	@GetMapping("/find/{name}")
	public List<User> findByName(@PathVariable("name") String name)
	{
		return userRepo.findByUserName(name);
	
	}
	
	@PostMapping("/findByEmail")
	public boolean checkEmailAvailable(@RequestBody String email) 
	{	
		User u=userRepo.findByEmail(email);
		System.out.println(u);
		return u==null;
	}
	
	@PostMapping("/findByPhone")
	public boolean checkPhoneAvailable(@RequestBody String phone) 
	{
		System.out.println(userRepo.findByPhone(phone));
		return userRepo.findByPhone(phone)==null;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginRequest credentials) 
	{
		return userRepo.findByEmailPasswordOrPhonePassword(credentials.userId, credentials.password);
	}
	
	@PostMapping("/addPlace")
	public Place addPlace(@RequestBody Place p,HttpServletRequest r) {
		
		p.setAddedBy(userRepo.findByEmail("arpan.pathak47@gmail.com"));
		return placeRepo.save(p);
	}

}
