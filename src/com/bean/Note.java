
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

import java.util.ArrayList;

public class Note {
	public int noteType, pinStatus, noteID, listID, accessRights;

	/**
	 * @return the noteID
	 */
	public int getNoteID() {
		return noteID;
	}

	/**
	 * @param noteID
	 *            the noteID to set
	 */
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String title, label;
	public ArrayList<String> content, collaborators = new ArrayList<>();

	/**
	 * @return the collaborators
	 */
	public ArrayList<String> getCollaborators() {
		return collaborators;
	}

	/**
	 * @param collaborators
	 *            the collaborators to set
	 */
	public void setCollaborators(ArrayList<String> collaborators) {
		this.collaborators = collaborators;
	}

	/**
	 * @return the content
	 */
	public ArrayList<String> getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(ArrayList<String> content) {
		this.content = content;
	}

	public boolean created;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the noteType
	 */
	public int getNoteType() {
		return noteType;
	}

	/**
	 * @param noteType
	 *            the noteType to set
	 */
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}

	/**
	 * @return the pinStatus
	 */
	public int getPinStatus() {
		return pinStatus;
	}

	/**
	 * @param pinStatus
	 *            the pinStatus to set
	 */
	public void setPinStatus(int pinStatus) {
		this.pinStatus = pinStatus;
	}

	/**
	 * @return the listID
	 */
	public int getListID() {
		return listID;
	}

	/**
	 * @param listID
	 *            the listID to set
	 */
	public void setListID(int listID) {
		this.listID = listID;
	}

	/**
	 * @return the accessRights
	 */
	public int getAccessRights() {
		return accessRights;
	}

	/**
	 * @param accessRights
	 *            the accessRights to set
	 */
	public void setAccessRights(int accessRights) {
		this.accessRights = accessRights;
	}

	/**
	 * @return the lable
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param lable
	 *            the lable to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCreated() {
		// TODO Auto-generated method stub
		return created;
	}

	public void setCreated(boolean newCreated) {
		created = newCreated;
	}

}
