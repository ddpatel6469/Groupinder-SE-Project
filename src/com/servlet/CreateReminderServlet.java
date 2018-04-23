/*
 *  @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Last modified: 08/14/2017
 * version 7
 * Groupinder Web-application.
 * 
 */

package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Reminder;
import com.dao.CreateReminderDAO;
import com.twilio.rest.preview.bulkExports.export.Day;

/**
 * Servlet implementation class CreateReminderServlet
 */
public class CreateReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReminderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reminder new_reminder = new Reminder();
		new_reminder.setNote_id(Integer.parseInt(request.getParameter("noteID")));
		
		String day = request.getParameter("daytime"); 
		String[] parts = day.split("T");
		day = parts[0] + " " + parts[1] + ":00";
		new_reminder.setDate(day);
		new_reminder.setMessage(request.getParameter("reminderMessage"));
		new_reminder.setMedium("1");
		CreateReminderDAO.create(new_reminder);
		response.sendRedirect("user.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
