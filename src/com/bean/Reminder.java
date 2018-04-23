 /* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 07/01/2017. (mm/dd/yyyy)
 * Last modified: 07/19/2017. (mm/dd/yyyy)
 * version 7
 * Groupinder Web-application.
 * References:
 	1. http://getbootstrap.com/
 	2. https://www.w3schools.com/
 	3.
 	
 */
package com.bean;

public class Reminder {
	public String hours;
	public String minutes;
	public String seconds;
	public String note_title;
	public String date;
	public String y, m, d; // for using the variables and fetching values in calendar.jsp
	public int reminder_id;
	public int note_id;
	public String medium;
	public String message;
	boolean isReminderCreate;

	/**
	 * @return the note_id
	 */
	public int getNote_id() {
		return note_id;
	}

	/**
	 * @param note_id
	 *            the note_id to set
	 */
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * @return the m
	 */
	public String getM() {
		return m;
	}

	/**
	 * @param m
	 *            the m to set
	 */
	public void setM(String m) {
		this.m = m;
	}

	/**
	 * @return the d
	 */
	public String getD() {
		return d;
	}

	/**
	 * @param d
	 *            the d to set
	 */
	public void setD(String d) {
		this.d = d;
	}

	/**
	 * @return the note_title
	 */
	public String getNote_title() {
		return note_title;
	}

	/**
	 * @param note_title
	 *            the note_title to set
	 */
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	/**
	 * @return the seconds
	 */
	public String getSeconds() {
		return seconds;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	/**
	 * @return the hours
	 */

	public String getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */

	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * @return the minutes
	 */

	public String getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes
	 *            the minutes to set
	 */

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the date
	 */

	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return true if reminder created
	 */

	public boolean isReminderCreate() {
		return isReminderCreate;
	}

	/**
	 * @param create
	 *            reminder the create reminder to set
	 */

	public void setReminderCreate(boolean isReminderCreate) {
		this.isReminderCreate = isReminderCreate;
	}

	/**
	 * @return true if reminder id created
	 */

	public int getReminder_id() {
		return reminder_id;
	}

	/**
	 * @param reminder
	 *            id the reminder id to set
	 */

	public void setReminder_id(int reminder_id) {
		this.reminder_id = reminder_id;
	}

	/**
	 * @return medium created
	 */

	public String getMedium() {
		return medium;
	}

	/**
	 * @param medium
	 *            the medium to set
	 */

	public void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * @return message created
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */

	public void setMessage(String message) {
		this.message = message;
	}

}
