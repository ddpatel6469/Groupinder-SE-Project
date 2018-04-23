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

/*
 * The class FetchEventsReminderDAO creates a currentConnection to connect with database 
 * result sets to execute the query.
 */

public class fetchNotesDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null, resutltsetContents = null, resutltsetCollaborators = null;
	static ResultSet resultset_lable = null;

	/*
	 * This method creates connection with the database to search notes it
	 * searches for the notes, note contents and collaborators executes the
	 * query and sets the values in the respective bean classes and adds the
	 * values in the notes arraylist if the query is executed, everything is
	 * displayed on the UI otherwise throws an exception closes the connection
	 * with database.
	 */

	public static ArrayList<Note> fetch(User current_user, ArrayList<Note> notes, String note_label,
			String search_key) {
		Statement statement = null, statementContents = null, statementCollaborators = null;
		String searchNotes, searchNoteContents, searchCollaborators;
		int userID = current_user.getUser_id();

		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			statementContents = CurrentConnection.createStatement();
			statementCollaborators = CurrentConnection.createStatement();

			if (note_label != null) {
				searchNotes = "SELECT note.note_id,note.pin_status,note.title,note_lable.lable"
						+ " FROM `note` INNER JOIN `note_lable` ON note.note_id = note_lable.note_id"
						+ " WHERE `note`.`note_id` IN (SELECT collaborators.note_id "
						+ " FROM collaborators WHERE collaborators.user_id = '" + userID + "') AND note_lable.lable = '"
						+ note_label + "'";

				searchNoteContents = "SELECT note.note_id,note_contents.contents"
						+ " FROM `note` INNER JOIN `note_contents` ON `note`.`note_id` = `note_contents`.`note_id`"
						+ " WHERE `note`.`note_id` IN (SELECT collaborators.note_id "
						+ " FROM collaborators WHERE collaborators.user_id = '" + userID + "')";

			} else {
				searchNotes = "SELECT note.note_id,note.pin_status,note.title,note_lable.lable"
						+ " FROM `note` INNER JOIN `note_lable` ON note.note_id = note_lable.note_id"
						+ " WHERE `note`.`note_id` IN (SELECT collaborators.note_id "
						+ " FROM collaborators WHERE collaborators.user_id = '" + userID + "')";

				searchNoteContents = "SELECT note.note_id,note_contents.contents"
						+ " FROM `note` INNER JOIN `note_contents` ON `note`.`note_id` = `note_contents`.`note_id`"
						+ " WHERE `note`.`note_id` IN (SELECT collaborators.note_id "
						+ " FROM collaborators WHERE collaborators.user_id = '" + userID + "')";
			}
			searchCollaborators = "SELECT a.*,user.user_name FROM `collaborators` as a INNER JOIN `collaborators` as b INNER JOIN user ON b.user_id = user.user_id "
					+ "WHERE a.user_id = '" + userID + "' AND a.user_id <> b.user_id AND b.note_id = a.note_id";

			resultset = statement.executeQuery(searchNotes);
			resutltsetContents = statementContents.executeQuery(searchNoteContents);
			resutltsetCollaborators = statementCollaborators.executeQuery(searchCollaborators);

			while (resultset.next()) {
				ArrayList<String> content = new ArrayList<>();
				ArrayList<String> collaborators = new ArrayList<>();
				Note note = new Note();

				note.setNoteID(resultset.getInt(1));

				note.setPinStatus(resultset.getInt(2));

				note.setTitle(resultset.getString(3));

				while (resutltsetContents.next()) {

					if (resutltsetContents.getInt(1) == resultset.getInt(1)) {
						content.add(resutltsetContents.getString(2));
					}
				}
				note.setContent(content);

				while (resutltsetCollaborators.next()) {
					if (resutltsetCollaborators.getInt(1) == resultset.getInt(1)) {
						collaborators.add(resutltsetCollaborators.getString(4));
					}
				}
				note.setCollaborators(collaborators);

				System.out.println("label   :" + resultset.getString(4));
				note.setLabel(resultset.getString(4));

				if (search_key != null) {
					if (note.title.contains(search_key) || note.content.contains(search_key))
						notes.add(note);
				} else {
					notes.add(note);
				}

				resutltsetContents.first();
				resutltsetCollaborators.first();
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

		return notes;
	}

}
