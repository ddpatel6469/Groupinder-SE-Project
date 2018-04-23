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

import org.junit.Test;

import com.bean.Note;
import com.bean.Reminder;
import com.dao.CreateReminderDAO;

public class CreateReminderTest {
	//int list_id=0;
	String date="2017/08/15";
	String medium="email";
	String message="hello";
	int note_id=15;
	
	CreateReminderDAO test_createReminder=new CreateReminderDAO();
	
	@Test
	public void reminderTest(Reminder reminder) throws Exception {
		Reminder test_reminder=new Reminder();
		test_reminder.setDate(date);
		test_reminder.setMedium(medium);
		test_reminder.setMessage(message);
		test_reminder.setNote_id(note_id);
		
		Reminder returnValue=CreateReminderDAO.create(test_reminder);
		
		if (returnValue.equals("Reminder Creation can not be done.")){
	        throw new Exception("Reminder could not be created");
	      }
	}

}
