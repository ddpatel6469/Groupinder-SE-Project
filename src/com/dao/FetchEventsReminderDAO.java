/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * References: www.codejava.net

 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Reminder;
import com.bean.User;

/*
 * The class FetchEventsReminderDAO creates a currentConnection to connect with database 
 * result set to execute the query.
 */

public class FetchEventsReminderDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null;

	/*
	 * This method creates connection with the database it fetches the values of
	 * reminders for particular date and time and sets the values respectively
	 * in the reminder bean class to be displayed on the UI Executes the
	 * reminder and returns reminders otherwise throws and exception closes the
	 * connection with database.
	 */

	public static ArrayList<Reminder> FetchEventsReminders(User current_user) {
		Statement statement = null;
		int userID = current_user.getUser_id();
		ArrayList<Reminder> event_reminders = new ArrayList<Reminder>();
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			String searchEventReminders = "SELECT note.title,reminder.time FROM `reminder` INNER JOIN `note` ON reminder.note_id=note.note_id INNER JOIN `collaborators` ON collaborators.note_id=reminder.note_id WHERE collaborators.user_id='"
					+ userID + "'";
			resultset = statement.executeQuery(searchEventReminders);

			while (resultset.next()) {
				String fetch_time = resultset.getString(2);
				String[] parts = fetch_time.split(" ");
				String date = parts[0];
				String time = parts[1];
				String[] time_parts = time.split(":");
				String hours = time_parts[0];
				String minutes = time_parts[1];
				String seconds = "00";

				Reminder reminder_event = new Reminder();

				
				reminder_event.setNote_title(resultset.getString(1));

				
				reminder_event.setDate(date);
				reminder_event.setHours(hours);
				reminder_event.setMinutes(minutes);
				reminder_event.setSeconds("00");
				String[] date_parts = date.split("-");
				reminder_event.setY(date_parts[0]);
				reminder_event.setM(date_parts[1]);
				reminder_event.setD(date_parts[2]);
				event_reminders.add(reminder_event);
			}

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

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
		return event_reminders;

	}
}
