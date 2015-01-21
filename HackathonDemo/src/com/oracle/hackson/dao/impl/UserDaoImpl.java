package com.oracle.hackson.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.oracle.hackson.bean.User;

@Repository("userDAO")
@SuppressWarnings("all")
public class UserDaoImpl extends BasicDAOImpl<User>{
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail("23424sd@gasdf.com");
		user.setName("Ë«¿ª¶Ô·½½²¿Î");
		user.setGender("M");
		user.setSingle("Y");
		user.setSexualPrefer("FM");
		user.setPasswd("sdfjklsajfk");
		//new UserDaoImpl().save(user);
		System.out.println(new UserDaoImpl().find(" from User").get(0).getEmail());
	}

}
