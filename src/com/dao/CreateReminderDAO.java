/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified:  08/14/2017
 * version 7
 * Groupinder Web-application.
 * References:http://howtodoinjava.com/security/java-aes-encryption-example/

 */
package com.dao;

import java.sql.*;
import com.bean.Reminder;

/*
 * The createReminderDAO class creates a connection, result sets to execute the queries 
 * statement to check if the query executes or not and create connection
 */
public class CreateReminderDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset_ = null;
	static Statement statement = null;

	/*
	 * creates connection to the database creates a reminder by inserting values
	 * in the reminder table. sets the values to the respective variables in the
	 * reminder bean once the query is executed, reminder is created else goes
	 * to exception closes the connection
	 */
	public static Reminder create(Reminder new_reminder) {

		int list_id = 0;
		String date = new_reminder.getDate();
		String medium = new_reminder.getMedium();
		String message = new_reminder.getMessage();
		int note_id = new_reminder.getNote_id();

		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			String insertQuery = "INSERT INTO `reminder` VALUES( NULL,'" + note_id + "','" + list_id + "','" + date
					+ "','" + medium + "','" + message + "');";
			statement.execute(insertQuery);
			new_reminder.setReminderCreate(true);
		} catch (Exception e) {
			new_reminder.setReminderCreate(false);
			
			System.out.println(e.getMessage());
		} finally {

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
		return new_reminder;

	}
}
