package com.ty.hospitalapp.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospitalapp.dao.UserDao;
import com.ty.hospitalapp.dto.User;

public class UserDaoImp implements UserDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public User saveUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	public boolean deleteUserById(int uid) {
		User user = entityManager.find(User.class, uid);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public User getUserById(int uid) {
		User user = entityManager.find(User.class, uid);
		if (user != null) {
			return user;
		}
		return null;
	}
	public User updateUserById(int uid, User user) {
		User user1 = entityManager.find(User.class, uid);
		if (user1 != null) {
			user1.setEmail(user.getEmail());
			user1.setName(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setPhone(user.getPhone());
			
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			
			return user1;
		}
		return null;
	}
	public List<User> getAllUser() {
		Query query = entityManager.createQuery("select s from User s");
		List<User> users = query.getResultList();
		return users;
	}
	public List<User> getUserByRole(String role) {
		Query query = entityManager.createQuery("SELECT o.role FROM User o WHERE o.role =?");
		query.setParameter(1, role);
		List <User> users = query.getResultList();
		return users;
	}

}
