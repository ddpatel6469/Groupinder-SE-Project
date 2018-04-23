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

import com.bean.*;
import com.dao.UserLoginDAO;


public class LoginTest {

		
	      String username = "shaunaksangdod@gmail.com";
	      String password = "Idntknw18";
	      
	      
	     UserLoginDAO test_login =new UserLoginDAO();
	    
	    @Test
	    public void LoginUser() throws Exception{
	      //invoke the method on the service.
	     User new_user=new User();
		 new_user.setUser_name(username);
		 new_user.setPassword(password);
		      
	     User returnValue =test_login.login(new_user);

	      if (returnValue.equals("login failed.")){
	        throw new Exception("User could not login ");
	      }
	    }
	}

