
/*
 *  @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * 
 */
package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bean.User;
import com.dao.UserLoginDAO;
import com.dao.UserRegistrationDAO;

public class RegisterTest {
	String user_name="demo user";
	String email="demox@user.com";
	String password="admin@1234";
	String phone_number_countrycode="+1";
	String phone_number_main="5183332717";
	
	UserRegistrationDAO register_test=new UserRegistrationDAO();
	
	 @Test
	    public void RegisterUser() throws Exception{
		 User new_user=new User();
		 new_user.setUser_name(user_name);
		 new_user.setEmail(email);
		 new_user.setPhone_number_countrycode(phone_number_countrycode);
		 new_user.setPhone_number_main(phone_number_main);
		 new_user.setPassword(password);
		 
		 User returnValue =UserRegistrationDAO.register(new_user);
		 
		 if (returnValue.equals("User registration can not be done.")){
		        throw new Exception("User could not Register");
		      }
	 }
}
