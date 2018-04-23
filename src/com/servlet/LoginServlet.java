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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Note;
import com.bean.User;
import com.dao.UserLoginDAO;
import com.dao.fetchNotesDAO;
/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try{
			User current_user = new User();
			current_user.setUser_name(request.getParameter("email")); //user's email servs as username while logging in.
			current_user.setPassword(request.getParameter("passcode"));
			
			current_user = UserLoginDAO.login(current_user);
			
			if(current_user.isValid()){
			//	ArrayList<Note> notes = new ArrayList<Note>();
			//	notes = fetchNotesDAO.fetch(current_user, notes);
				HttpSession session = request.getSession(true);
			//	session.setAttribute("notes", notes);
				session.setAttribute("currentUser", current_user);
				response.sendRedirect("user.jsp");
			}else{
				response.sendRedirect("error.jsp");
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
