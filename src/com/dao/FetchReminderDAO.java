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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.*;

/*
 * The class FetchEventsReminderDAO creates a currentConnection to connect with database 
 * result sets to execute the query.
 */

public class FetchReminderDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null;

	/*
	 * This method creates connection with the database and is used to fetch
	 * reminders for the user it executes a select query to fetch the values of
	 * the reminders and sets them in the reminder bean class once the values
	 * are fetched it adds to the arraylist of type reminders to be displayed on
	 * the UI otherwise throws an exception closes the connection with database.
	 */

	public static ArrayList<Reminder> FetchReminders(User current_user) {
		Statement statement = null;
		int userID = current_user.getUser_id();
		ArrayList<Reminder> view_reminders = new ArrayList<Reminder>();
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			String searchReminders = "SELECT note.note_id,note.title,reminder.time,reminder.medium,reminder.message,reminder.reminder_id "
					+ "FROM `reminder` INNER JOIN `note` ON reminder.note_id=note.note_id "
					+ "INNER JOIN `collaborators` ON collaborators.note_id=reminder.note_id "
					+ "WHERE collaborators.user_id='" + userID + "'";
			resultset = statement.executeQuery(searchReminders);

			while (resultset.next()) {
				Reminder reminder = new Reminder();
				reminder.setReminder_id(resultset.getInt(6));
				reminder.setNote_id(resultset.getInt(1));
				reminder.setNote_title(resultset.getString(2));
				reminder.setMedium(resultset.getString(4));
				reminder.setMessage(resultset.getString(5));
				String[] parts = resultset.getString(3).split(" ");
				String date = parts[0] + "T" + parts[1];
				reminder.setDate(date);
				view_reminders.add(reminder);
			}

		} catch (Exception e) {
			
			System.out.println(e.getMessage());

		}

		// closing connections
		finally {

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

		return view_reminders;
	}
}
