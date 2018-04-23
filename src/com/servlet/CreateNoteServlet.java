/*
 *  @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
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
import com.bean.User;
import com.dao.createNoteDAO;

/**
 * Servlet implementation class CreateNoteServlet
 */
public class CreateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int length = request.getParameterValues("noteContent").length;
		
		String[] contents = request.getParameterValues("noteContent");
		for(int i=0; i<length; i++){
			System.out.println(contents[i]);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
			Note new_note = new Note();
			ArrayList<String> content = new ArrayList<>();
			new_note.setTitle(request.getParameter("noteTitle"));
			int length = request.getParameterValues("noteContent").length;
			
			String[] contents = request.getParameterValues("noteContent");
			for(int i=0; i<length; i++){
				content.add(contents[i]);
				System.out.println(contents[i]);
			}
			
			new_note.setContent(content);
			new_note.setLabel(request.getParameter("noteLabel"));
			
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute("currentUser");
			new_note = createNoteDAO.create(new_note,user);

			if(new_note.isCreated()){
				session.setAttribute("notes", "x");
				response.sendRedirect("user.jsp");
			}else{
				response.sendRedirect("invalidLogin.jsp");
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
