/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified:  08/14/2017
 * version 7
 * Groupinder Web-application.
 * References:

 */

/**
 * 
 */
package com.dao;

import java.sql.*;

/**
 * @author Team 7
 * 
 *
 */
public class DbConnection {

	/**
	 * @param args
	 *            connect of type Connection
	 */
	public static Connection connect = null;

	/*
	 * this method is used to create a JDBC connection to the database by
	 * loading the jdbc driver and setting up the connection with MySql databse.
	 * If the connection is not created succcessfully, it throws an exception.
	 */

	public static Connection getConnection() {

		String host = "localhost", user = "root", password = "";

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "/groupinder?" + "user=" + user + "&password=" + password);

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());

		}

		return connect;
	}

}
