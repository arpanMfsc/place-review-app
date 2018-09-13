package com.reviewapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reviewapp.model.User;

@Repository
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

	/**
	 * This method will return user based on email/password and phone
	 * @param String emailOrPhone
	 * @param String password
	 * @return instance of User from the query
	 */
	 @Query(value = "SELECT * FROM USERS WHERE (email = ?1 or phone=?1) and password=?2", nativeQuery = true)
	User findByEmailPasswordOrPhonePassword(String emailOrPhone,String password);
	 
}
