package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.User;



public interface UserDAO {
	
	   public List<User> getAllUser();
	   public  User getUser(int userid);
	   public void insertUser(User user);
	   public User updateUser(int id ,User user);
	   public void deleteUser(int id);
	   public void deleteallUser(User user);
	  
}
