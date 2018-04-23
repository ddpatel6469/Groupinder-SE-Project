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
import javax.websocket.Session;

import com.bean.Reminder;
import com.dao.EditReminderDAO;

/**
 * Servlet implementation class EditReminderServlet
 */
public class EditReminderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReminderServlet() {
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
		// TODO Auto-generated method stub
		Reminder new_reminder = new Reminder();
		ArrayList<Reminder> reminders = new ArrayList<Reminder>();
		HttpSession session = request.getSession(true);
		reminders = (ArrayList<Reminder>) session.getAttribute("reminders");
		new_reminder.setReminder_id(Integer.parseInt(request.getParameter("reminder_id")));
		String day = request.getParameter("daytime"); 
		String[] parts = day.split("T");
		day = parts[0] + " " + parts[1];
		new_reminder.setDate(day);
		new_reminder.setMessage(request.getParameter("message"));
		if(EditReminderDAO.edit(new_reminder)){
			for(int i=0;i<reminders.size();i++){
				Reminder reminder = reminders.get(i);
				if(reminder.reminder_id == new_reminder.reminder_id){
					reminder.message = new_reminder.message;
					 day = new_reminder.date; 
					 parts = day.split(" ");
					 day = parts[0] + "T" + parts[1];
					reminder.date = day;
				}
			}
			session.setAttribute("reminders", reminders);
			response.sendRedirect("viewReminders.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
