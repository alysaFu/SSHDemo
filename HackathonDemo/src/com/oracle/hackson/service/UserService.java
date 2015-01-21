package com.oracle.hackson.service;

import com.oracle.hackson.bean.User;

public interface UserService {
	
	public User getUserByEmail(String email);
	
	public boolean isUserExist(String email);
	
	public void addUser(User user);

	public void updateUser(User user);

	public User findUserByEmailAndPassword(String email, String passwd);
	
}
