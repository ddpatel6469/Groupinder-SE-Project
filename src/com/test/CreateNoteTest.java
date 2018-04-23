/*
 *  @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * 
 */
package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bean.Note;
import com.bean.User;

import com.dao.createNoteDAO;

public class CreateNoteTest {
	String title = "hello";
	int pin_status = 0;
	ArrayList<String> content = new ArrayList<String>();
	
	String label = "label";
	int note_id = 0,listID = 0;
	int userID = 15;
	
	
	createNoteDAO test_create_note=new createNoteDAO();
	@Test
	public void createNotetest(Note note, User user) throws Exception {
		content.add("message");
		User new_user=new User();
		Note new_note=new Note();
		new_user.setUser_id(userID);
		new_note.setTitle(title);
		new_note.setPinStatus(pin_status);
		new_note.setContent(content);
		new_note.setNoteID(note_id);
		new_note.setLabel(label);
		new_note.setContent(content);
		new_note.setListID(listID);
		
		Note returnValue =createNoteDAO.create(new_note, new_user);
		
		if (returnValue.equals("Note Creation can not be done.")){
	        throw new Exception("Note could not be created");
	      }
		
	}

}
