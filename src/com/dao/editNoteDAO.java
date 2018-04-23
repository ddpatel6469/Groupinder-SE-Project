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

import com.bean.Note;
import com.bean.User;
import com.dao.DbConnection;

/*
 * The class editNoteDAO creates a currentConnection to connect with database 
 * Success variables to check if the query executes. 
 * creates resultset to execute queries.
 */

public class editNoteDAO {

	static Connection CurrentConnection = null;
	static int succsess_insert_note = 0, succsess_map_user = 0, succsess_map_content = 0, succsess_map_label = 0;
	static ResultSet resultset_note_id = null, resultset_list_id = null;

	/*
	 * This method creates connection with the database and lets user to edit
	 * the notes it fires a select query first to obtain the note which user
	 * wants to modify Updates the contents, label and title of the note as per
	 * user and then inserts the same in the database. Executes all the queries
	 * and if the note is edited it sets the noteCreated variable of note bean
	 * to true else throws exception. closes the database connection.
	 */

	public static Note edit(Note new_note, User user) {
		Statement statement = null;
		String title = new_note.getTitle();
		int pin_status = 0;
		ArrayList<String> content = new_note.getContent();
		String label = new_note.getLabel();
		int note_id = new_note.getNoteID(), listID = 0;
		int userID = user.getUser_id();

		try {
			// fetch note id and calculate the next one.
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();

			
			int max_list_id = 0;
			String maxListID = "select max(list_id) as `maxlistID` from `note_contents` WHERE note_id = '" + note_id
					+ "'";
			resultset_list_id = statement.executeQuery(maxListID);
			while (resultset_list_id.next()) {
				max_list_id = resultset_list_id.getInt(1);
			}

			

			String updateQuery = "UPDATE `note` SET title = '" + title + "' WHERE `note_id` = '" + note_id + "' ;";

			for (int i = 0; i < content.size(); i++) {
				if (content.get(i) != "" && content.get(i) != null) {

					if (i <= max_list_id) {
						String mapContent = "UPDATE `note_contents` SET contents = '" + content.get(i)
								+ "' WHERE `note_id` = '" + note_id + "' AND list_id = '" + i + "'  ;";
						succsess_map_content = statement.executeUpdate(mapContent);
					} else {
						String mapContent = "INSERT INTO `note_contents` VALUES('" + note_id + "','" + i + "','"
								+ content.get(i) + "');";
						succsess_map_content = statement.executeUpdate(mapContent);
					}
				}

			}

			String mapLabel = "UPDATE `note_lable` SET lable = '" + label + "' WHERE `note_id` = '" + note_id + "' ;";
			succsess_insert_note = statement.executeUpdate(updateQuery);
			

			succsess_map_label = statement.executeUpdate(mapLabel);
			new_note.setCreated(true);

		} catch (Exception e) {
			new_note.setCreated(false);
			System.out.println("Note Creation can not be done.");
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

		return new_note;
	}
}
