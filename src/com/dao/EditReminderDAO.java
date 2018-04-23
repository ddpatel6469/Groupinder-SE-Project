
/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:

 */
package com.dao;

import com.bean.Reminder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.dao.DbConnection;

/*
 * The class EditReminderDAO creates a currentConnection to connect with database 
 * Success variables to check if the query executes. 
 */

public class EditReminderDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;

	/*
	 * The method creates connection with the database. Updates the reminder as
	 * per the new time and date executes the update query and updates reminder
	 * in the database if query is executed it returns true otherwise throws an
	 * exception
	 */

	public static boolean edit(Reminder new_reminder) {
		Statement statement = null;

		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			String updateReminder = "UPDATE reminder SET time ='" + new_reminder.date + "', message = '"
					+ new_reminder.message + "' " + "WHERE reminder_id = '" + new_reminder.reminder_id + "'";
			succsess = statement.executeUpdate(updateReminder);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
