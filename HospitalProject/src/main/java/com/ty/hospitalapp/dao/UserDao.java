package com.ty.hospitalapp.dao;

import java.util.List;

import com.ty.hospitalapp.dto.User;

public interface UserDao {
	User saveUser(User user);
	
	boolean deleteUserById(int uid);
	
	User getUserById(int uid);
	
	User updateUserById(int uid, User user);
	
	List<User> getAllUser();
	
	List<User> getUserByRole(String role);
	 
}
