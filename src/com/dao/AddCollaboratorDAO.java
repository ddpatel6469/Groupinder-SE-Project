/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * References:http://howtodoinjava.com/security/java-aes-encryption-example/

 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.bean.User;

/*
 * class AddCollaboratorDAO creates a connection for accessing database
 * result set to execute the query and show success
 */

public class AddCollaboratorDAO {

	static Connection CurrentConnection = null;
	static ResultSet resultset = null;
	static int succsess = 0;

	/*
	 * This method adds a new collaborator if the user already exists. if the
	 * user is not present a registration request is sent it fires a Select query
	 * and then inserts the new collaborator in the database updates the
	 * database and sets the values in user bean class to be shown on the UI an
	 * email is sent to the collaborator
	 */

	public static boolean add(String email, String noteID) {

		// If the user already exists, simply add. otherwise send a registration
		// request.

		Statement statement = null;
		String checkUser = "SELECT user_id FROM user WHERE email = '" + email + "'";
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			resultset = statement.executeQuery(checkUser);

			boolean user_available = resultset.next();

			if (user_available) {
				String addCollaborator = "INSERT INTO collaborators VALUES ('" + noteID + "','" + resultset.getInt(1)
						+ "','1')"; // 1 = edit permission
				succsess = statement.executeUpdate(addCollaborator);
				return true;
			} else {
				System.out.println("adding new user");
				User new_user = new User();
				new_user.setEmail(email);
				new_user.setPassword("Temp@123");
				new_user.setUser_name("new_user");
				UserRegistrationDAO.register(new_user);
				if (new_user.isRegistered()) {
					System.out.println("Sending mail to new user");
					try {
						EmailUtility.sendEmail(new_user.email, "Cheers! ",
								"Welcome, " + new_user.email + "\n " + "you're all set, Start Noting! \n "
										+ "Sign in with your Email. Your password is : Temp@123. We highly recommend to change it ASAP."
										+ "\n Thanks,\n Team Groupiner");
						System.out.println("Mail sent to new user.");
					} catch (AddressException e) {

						e.printStackTrace();
					} catch (MessagingException e) {

						e.printStackTrace();
					}

				}
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

}
