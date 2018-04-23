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
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Note;
import com.bean.Reminder;
import com.bean.User;
import com.dao.FetchReminderDAO;

/**
 * Servlet implementation class ViewRemindersServlet
 */
public class ViewRemindersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRemindersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		User current_user =(User) session.getAttribute("currentUser");	
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		reminders = FetchReminderDAO.FetchReminders(current_user);
		session.setAttribute("reminders", reminders);
		response.sendRedirect("viewReminders.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
