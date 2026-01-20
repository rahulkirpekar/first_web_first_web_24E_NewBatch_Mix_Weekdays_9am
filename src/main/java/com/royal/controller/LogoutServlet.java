package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		if(session == null) 
		{
			response.sendRedirect("login.jsp");
		}else 
		{
			// session - destroy
			session.invalidate();
			
			request.setAttribute("logoutsuccess", "<font color ='green'> Logout successfully...!</font>");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
