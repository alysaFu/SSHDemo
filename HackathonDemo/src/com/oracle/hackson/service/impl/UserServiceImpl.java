package com.oracle.hackson.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.bean.User;
import com.oracle.hackson.dao.BasicDAO;
import com.oracle.hackson.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	private BasicDAO<User> userDAO;
	
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.get(" from User u where u.email = ?", 
				new Object[] {email});
//		return userDAO.get(User.class, email);
	}

	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		return userDAO.find(" from User") == null || 
			   userDAO.find(" from User").size() == 0 ? false : true;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}
	
	@Override
	public User findUserByEmailAndPassword(String email, String passwd) {
		// TODO Auto-generated method stub
		return userDAO.get(" from User u where u.email = ? and u.passwd = ?", 
				new Object[] {email, passwd});
	}
	@Resource
	public void setUserDAO(BasicDAO<User> userDAO){
		this.userDAO = userDAO;
	}
	
	public BasicDAO<User> getUserDAO(){
		return userDAO;
	}
	
	// for test
	public static void main(String[] args){
		//User user = new UserServiceImpl().findUserByEmailAndPassword("234","234");
		System.out.println(new UserServiceImpl().isUserExist("23423432"));
	}
}
