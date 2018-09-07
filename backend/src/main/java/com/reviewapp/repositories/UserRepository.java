package com.reviewapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reviewapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * This method will find all the user by userName
	 * @param userName
	 * @return
	 */
	List<User> findByUserName(String userName);	
	
	/**
	 * This method will find a user by email
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
	
	/**
	 * This method will find a user by phoneNo
	 * @param phone
	 * @return
	 */
	User findByPhone(String phone);

	// find by email-password or phone-password
	 @Query(value = "SELECT * FROM USERS WHERE (email = ?1 or phone=?1) and password=?2", nativeQuery = true)
	User findByEmailPasswordOrPhonePassword(String emailOrPhone,String password);
	
	User findByUserNameAndPassword(String userName,String password);
}
