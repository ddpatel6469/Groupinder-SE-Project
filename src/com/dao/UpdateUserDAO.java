/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified:08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:https://www.twilio.com/blog/2014/04/add-sms-to-your-web-app-in-4-lines-of-code.html

 */
package com.dao;

import java.sql.*;

import com.bean.User;
import com.controller.AES_encryption;

/*
 * The class UpdateUserDAO creates a currentConnection to connect with database 
 * 
 */

public class UpdateUserDAO {
	static Connection CurrentConnection = null;

	/*
	 * This method creates connection with the database and is used to update
	 * the user information through the user_id it can update the user details
	 * as per user and execute an update query Returns true if the updation is
	 * done otherwise returns false and throws an exception. closes the database
	 * connection.
	 */

	public static boolean updateUser(User user) {
		try {
			Statement statement = null;
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			int user_id = user.getUser_id();
			String user_name = user.getUser_name();
			String email = user.getEmail();
			String password = user.getPassword();
			final String secretKey = "ssshhhhhhhhhhh!!!!";
			password = AES_encryption.encrypt(password, secretKey);// Encrypting
																	// password
			String phone_number_country_code = "+1";
			String phone_number_main = user.getPhone_number_main();

			String update_user_query = "UPDATE `user` SET `user_name` = '" + user_name + "', " + "`email`= '" + email
					+ "', " + "`password` = '" + password + "', " + "`phone_number_country_code` = '"
					+ phone_number_country_code + "', " + "`phone_number_main` = '" + phone_number_main
					+ "' WHERE `user`.`user_id` = '" + user_id + "'";

			int temp = statement.executeUpdate(update_user_query);

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
