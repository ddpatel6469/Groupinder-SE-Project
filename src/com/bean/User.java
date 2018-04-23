/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
 * Last modified: 
 * version 7
 * Groupinder Web-application.
 * References:

 */

package com.bean;

public class User {
	public int user_id;
	public String user_name, email, phone_number_countrycode, phone_number_main;
	private String password;
	public boolean valid, registered;

	/**
	 * @return the user_id
	 */
	
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_name
	 */
	
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 *            the user_name to set
	 */
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the email
	 */
	
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone_number_countrycode
	 */
	
	public String getPhone_number_countrycode() {
		return phone_number_countrycode;
	}

	/**
	 * @param phone_number_countrycode
	 *            the phone_number_countrycode to set
	 */
	
	public void setPhone_number_countrycode(String phone_number_countrycode) {
		this.phone_number_countrycode = phone_number_countrycode;
	}

	/**
	 * @return the phone_number_main
	 */
	
	public String getPhone_number_main() {
		return phone_number_main;
	}

	/**
	 * @param phone_number_main
	 *            the phone_number_main to set
	 */
	
	public void setPhone_number_main(String phone_number_main) {
		this.phone_number_main = phone_number_main;
	}

	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return true or false after checking the user
	 */

	public boolean isValid() {
		return valid;
	}

	/**
	 * @param set
	 *            true or false after checking user
	 */

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	/**
	 * @return true or false after registering the user
	 */

	public boolean isRegistered() {

		return registered;
	}

	/**
	 * @param set
	 *            true or false after registering user
	 */

	public void setRegistered(boolean newRegistered) {
		registered = newRegistered;
	}
}
