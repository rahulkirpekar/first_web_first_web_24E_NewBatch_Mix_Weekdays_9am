package com.royal.controller;

import java.io.IOException;

import com.royal.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
	
		RequestDispatcher rd = null;
		
		if ((userName == null) ||  (password==null)) 
		{
			request.setAttribute("loginError", "<font color='red'> Logiin Failed due to Username and password are NULL...!</font");
			rd = request.getRequestDispatcher("login.jsp");
			
		} else 
		{
			UserDao userDao = new UserDao();
			
			boolean isAvailable = userDao.authenticateUser(userName, password);
			
			if (isAvailable) 
			{
				HttpSession session =  request.getSession();
				session.setAttribute("userName", userName);
				
				rd = request.getRequestDispatcher("studentregi.jsp");
				
			} else 
			{
				request.setAttribute("loginError", "<font color='red'> Logiin Failed due to Invalid Credentials...!</font");
				rd = request.getRequestDispatcher("login.jsp");
			}
		}
		rd.forward(request, response);
	}
}
