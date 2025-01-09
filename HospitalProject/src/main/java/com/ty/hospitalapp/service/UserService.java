package com.ty.hospitalapp.service;

import com.ty.hospitalapp.dao.imp.UserDaoImp;
import com.ty.hospitalapp.dto.User;

public class UserService {
UserDaoImp daoImp = new UserDaoImp();
	
	public void saveUserService(User user) {
		User userRt = daoImp.saveUser(user);
		if(userRt != null) {
			System.out.println("Data Saved");
		}
		else {
			System.out.println("Data was not saved !");
		}
	}
	
	public void deleteUserService(int uid) {
		boolean flag = daoImp.deleteUserById(uid);
		if(flag) {
			System.out.println("Data Deleted");
		}
		else {
			System.out.println("Data was not deleted!");
		}
	}
	
	public User getUserById(int uid) {
		User user = daoImp.getUserById(uid);
		if(user!= null) {
			return user;
		}
		else {
			return null;
		}
	}
	
	public void updateUserService(User user,int uid) {
		User userRt = daoImp.updateUserById(uid,user);
		if(userRt != null) {
			System.out.println("Data Updated");
		}
		else {
			System.out.println("Data was not updated !");
		}
	}

}
