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

import com.bean.Reminder;
import com.dao.DeleteReminderDAO;

/**
 * Servlet implementation class DeleteReminderServlet
 */
public class DeleteReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReminderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		HttpSession session = request.getSession(true);
		reminders = (ArrayList<Reminder>) session.getAttribute("reminders");
		int reminder_id = Integer.parseInt(request.getParameter("reminder_id"));
		if(DeleteReminderDAO.delete(reminder_id)){
			//update session too!
			for(int i=0;i<reminders.size();i++){
				Reminder reminder = reminders.get(i);
				if(reminder_id == reminder.reminder_id){
					reminders.remove(i);
				}
			}
			session.setAttribute("reminders", reminders);
			response.sendRedirect("viewReminders.jsp");
			
		}
	}

}
