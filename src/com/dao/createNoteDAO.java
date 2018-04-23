/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * References:

 */

/**
 * 
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
 * The createNoteDAO class creates a connection, result sets to execute the queries 
 * Success variables to check if the query executes or not. 
 */

public class createNoteDAO {
	static Connection CurrentConnection = null;
	static int succsess_insert_note = 0, succsess_map_user = 0, succsess_map_content = 0, succsess_map_label = 0;
	static ResultSet resultset_note_id = null, resultset_list_id = null;

	/*
	 * creates connection to the database This method first takes the note_id
	 * and list_id to create a note once the user clicks on create note the
	 * method then inserts the data in note, labels, note_contents, and
	 * collaborators if added any. it executes the query and sets the values in
	 * respective bean to display on UI once the note is created, the database
	 * connection is closed.
	 */

	public static Note create(Note new_note, User user) {
		Statement statement = null;
		String title = new_note.getTitle();
		int pin_status = 0;
		ArrayList<String> content = new_note.getContent();
		String label = new_note.getLabel();
		int note_id = 0, listID = 0;
		int userID = user.getUser_id();
		String getNoteID = "select max(note_id) as `maxNoteID` from `note`";

		try {
			// fetch note id and calculate the next one.
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			// new note id
			resultset_note_id = statement.executeQuery(getNoteID);
			while (resultset_note_id.next()) {
				note_id = resultset_note_id.getInt(1) + 1;
			}

			// now we have new note id. we can now insert in the database. but
			// first we need list id.
			String getListID = "select max(list_id) as `maxListID` from `note_contents` where `note_id` = '" + note_id
					+ "'";
			resultset_list_id = statement.executeQuery(getListID);
			while (resultset_list_id.next()) {
				listID = resultset_list_id.getInt(1);
				listID += listID;
			}

			String insertQuery = "INSERT INTO `note` VALUES('" + note_id + "','" + pin_status + "','" + title + "');";
			String mapUser = "INSERT INTO `collaborators` VALUES('" + note_id + "', '" + userID + "','" + 1 + "');"; // 1
																														// is
																														// access
																														// right.
																														// 1
																														// =
																														// modify.
			String mapLabel = "INSERT INTO `note_lable` VALUES('" + note_id + "','" + label + "');";
			succsess_insert_note = statement.executeUpdate(insertQuery);
			succsess_map_user = statement.executeUpdate(mapUser);
			succsess_map_label = statement.executeUpdate(mapLabel);
			for (int i = 0; i < content.size(); i++) {
				if (content.get(i) != "" && content.get(i) != null) {

					String mapContent = "INSERT INTO `note_contents` VALUES('" + note_id + "','" + i + "','"
							+ content.get(i) + "');";
					succsess_map_content = statement.executeUpdate(mapContent);

				}

			}
			new_note.setCreated(true);

		} catch (Exception e) {
			new_note.setCreated(false);
			
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
