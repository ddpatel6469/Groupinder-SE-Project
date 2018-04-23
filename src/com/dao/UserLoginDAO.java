/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Last modified:08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:

 */

package com.dao;

import java.sql.*;
import com.bean.User;
import com.dao.DbConnection;
import com.controller.AES_encryption;

/*
 * The class UserLoginDAO creates a currentConnection to connect with database 
 * and result set to execute query 
 */

public class UserLoginDAO {

	static Connection CurrentConnection = null;
	static ResultSet resultset = null;

	/*
	 * This method creates the connection with database and lets the user login
	 * by authenticating the user name and password the password is encrypted
	 * with AES. Checks the database if the user details are valid and lets the
	 * user login. if the user is valid, the method is executed otherwise throws
	 * an exception. closes connection with database
	 */

	public static User login(User current_user) {
		Statement statement = null;
		String userName = current_user.getUser_name();
		String password = current_user.getPassword();
		final String secretKey = "ssshhhhhhhhhhh!!!!";
		password = AES_encryption.encrypt(password, secretKey);// Encrypting
																// password.

		String searchQuery = "select * from user" + " where email= '" + userName + "' and password= '" + password
				+ "' ";

		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			resultset = statement.executeQuery(searchQuery);

			boolean user_available = resultset.next();

			if (!user_available) {
				current_user.setValid(false);
			} else {
				current_user.user_id = resultset.getInt("user_id");
				current_user.phone_number_main = resultset.getString("phone_number_main");
				current_user.phone_number_countrycode = resultset.getString("phone_number_country_code");
				current_user.user_name = resultset.getString("user_name");
				current_user.email = resultset.getString("email");
				current_user.setValid(true);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		// closing connections
		finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (Exception e2) {
					resultset = null;
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
					statement = null;
				}
			}

			if (CurrentConnection != null) {
				try {
					CurrentConnection.close();
				} catch (Exception e2) {
					CurrentConnection = null;
				}
			}
		}
		return current_user;

	}
}
