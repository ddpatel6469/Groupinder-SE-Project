
/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:

 */package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * The class FetchEventsReminderDAO creates a currentConnection to connect with database 
 * result sets to execute the query.
 */

public class ReminderDAO implements Runnable {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null;

	@SuppressWarnings("deprecation")
	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run() This method creates a connection with the
	 * database to send an email or a message to users as reminders It searches
	 * for the collaborators to whom the messages or emails are to be sent and
	 * calls the Email Utlity and SMS utility class to implement the same. if
	 * failed to send, throws and exception closes connection with database.
	 */

	public void run() {
		Statement statement = null;
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			Date d1 = new Date();
			Date d2 = new Date();
			d2.setMinutes(d1.getMinutes() + 1);
			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String currentTime = df.format(d1);
			String nextTime = df.format(d2);

			String searchQuery = "SELECT collaborators.user_id,user.email,reminder.* "
					+ "FROM collaborators INNER JOIN reminder on collaborators.note_id = reminder.note_id INNER JOIN user ON collaborators.user_id = user.user_id "
					+ "WHERE reminder.time BETWEEN '" + currentTime + "' AND '" + nextTime + "'";

			resultset = statement.executeQuery(searchQuery);

			while (resultset.next()) {
				if (resultset.getString(7) != "1") {

					EmailUtility.sendEmail(resultset.getString(2), "Reminder", resultset.getString(8));

				} else {

					SMSUtility.sendSMS("", resultset.getString(8));

				}
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}

	}
}
