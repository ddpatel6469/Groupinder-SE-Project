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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.EmailUtility;
import com.dao.UserRegistrationDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			User new_user = new User();
			new_user.setUser_name(request.getParameter("name"));
			new_user.setEmail(request.getParameter("email"));
			new_user.setPassword(request.getParameter("password")); //javascript has already checked the criteria
			new_user.setPhone_number_countrycode(request.getParameter("phone_number_country_code"));
			new_user.setPhone_number_main(request.getParameter("mobileno"));
			new_user = UserRegistrationDAO.register(new_user);
			
			if(new_user.isRegistered()){
				
				EmailUtility.sendEmail(new_user.email, "Cheers! ",
	                    "Welcome, "+ new_user.user_name +"\n you're all set, Start Noting! \n Thanks,\n Team Groupiner");
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("error.jsp");
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
