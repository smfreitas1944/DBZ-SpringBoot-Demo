package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	//login user
	public boolean login(String username, String password);
	
	//logout user
	public boolean logout(String authCookieToken);
	
	//register user (create)
	public boolean registerUser(User user);
	
	//get all users
	public List<User> getAllUsers();

	//get user by id
	public User getUserById(int id);
	
	//get user by username
	public User getUserByUsername(String username);
	
	//update user
	public int updateUser(User user);
	
	//delete user
	public boolean deleteUser(User user);
}
