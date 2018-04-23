/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:

 */
package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

	/*
	 * The class DeleteReminderDAO creates a currentConnection to connect with database 
	 * Success variable to check if the query executes. 
	 */

	public class DeleteReminderDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;

	/*
	 * The method creates the connection with database Deletes the reminder one
	 * the user selects the reminder to be removed. Executes the query and
	 * updates the database returns true if the reminder is deleted otherwise
	 * throws an exception and returns false
	 */

	public static boolean delete(int reminder_id) {
		Statement statement = null;
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			String deleteReminder = "DELETE from reminder WHERE reminder_id = '" + reminder_id + "'";
			succsess = statement.executeUpdate(deleteReminder);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
