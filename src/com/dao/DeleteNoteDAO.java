/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified:  08/14/2017
 * version 7
 * Groupinder Web-application.
 * References:

 */
package com.dao;

import com.dao.DbConnection;
import java.sql.*;

/*
 * The class DeleteNoteDAO creates a currentConnection to connect with database 
 * Success variable to check if the query executes. 
 */

public class DeleteNoteDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;

	/*
	 * The method deletes the note once the user clicks the delete button
	 * Removes not label, not content, collaborators and note entries. creates
	 * connection with the database and executes query once the note is deleted,
	 * it closes the connection otherwise throws an exception
	 */

	public static boolean deleteNote(String noteID) {
		String DeletenNotelabel = "DELETE FROM `note_lable` WHERE `note_id` = '" + noteID + "'";
		String DeletenNoteContents = "DELETE FROM `note_contents` WHERE `note_id` = '" + noteID + "'";
		String DeletenNoteCollaborators = "DELETE FROM `collaborators` WHERE `note_id` = '" + noteID + "'";
		String DeletenNoteEntry = "DELETE FROM `note` WHERE `note_id` = '" + noteID + "'";
		try {
			Statement statement = null;
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			statement.executeUpdate(DeletenNotelabel);
			statement.executeUpdate(DeletenNoteContents);
			statement.executeUpdate(DeletenNoteCollaborators);
			statement.executeUpdate(DeletenNoteEntry);
			return true;
		} catch (Exception e) {
			System.out.println("Note deletion can not be done.");
			System.out.println(e.getMessage());
			return false;
		}

	}
}
