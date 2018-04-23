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

import com.bean.*;
import com.dao.fetchNotesDAO;

/**
 * Servlet implementation class FetchNotesServlet
 */
public class FetchNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchNotesServlet() {
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
		
		ArrayList<Note> notes = new ArrayList<Note>();
		String label_key=null,search_key=null;
		label_key = request.getParameter("key");
		search_key = request.getParameter("search_key");
		notes = fetchNotesDAO.fetch(current_user, notes,label_key,search_key);
		session.setAttribute("notes", notes);
		session.setAttribute("page","search");
	
	//	RequestDispatcher view=request.getRequestDispatcher("user.jsp");
	  //  view.forward(request,response);
		if(label_key != null || search_key != null)
		response.sendRedirect("user.jsp?page=search");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**HttpSession session = request.getSession(true);
		User current_user =(User) session.getAttribute("currentUser");
		ArrayList<Note> notes = new ArrayList<Note>();
		notes = fetchNotesDAO.fetch(current_user, notes);
		session.setAttribute("notes", notes);
		response.sendRedirect("user.jsp");*/
	}

}
