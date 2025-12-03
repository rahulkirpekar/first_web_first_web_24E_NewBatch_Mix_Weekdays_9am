package com.royal.controller;

import java.io.IOException;

import com.royal.bean.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student s= new Student(1, "Rahul Kirpekar", 12);
		
		// SESSION SCOPE
		
		HttpSession session = request.getSession();
		
		session.setAttribute("rahulInfo", s);

		// application scope---data store---ServletContext
//		ServletContext applicationScope = getServletContext();
//		applicationScope.setAttribute("rahul", s);
		
/*
		// set object(value) in request scope
		request.setAttribute("rahul", s);
		RequestDispatcher rd = request.getRequestDispatcher("ganesh");
		rd.forward(request, response);
-----------------------------------------------------------------------------------------------------------------
		PrintWriter out = response.getWriter();
		
		ServletContext context	= getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		String lang4 = context.getInitParameter("lang4");

		out.print("<b>lang1</b> : " + lang1+"<br>");
		out.print("<b>lang2</b> : " + lang2+"<br>");
		out.print("<b>lang3</b> : " + lang3+"<br>");
		out.print("<b>lang4</b> : " + lang4+"<br>");
  		-----------------------------------------------------------------------------------------------------------------
		// get Servlet Config object
		ServletConfig config = getServletConfig();
		System.out.println("FirstServlet config : " + config);
		String urlName = config.getInitParameter("URLNAME");
		String driverClass = config.getInitParameter("DRIVERCLASS");
		String userName = config.getInitParameter("USERNAME");
		String password = config.getInitParameter("PASSWORD");
		out.print("<b>urlName</b> : " + urlName+"<br>");
		out.print("<b>driverClass</b> : " + driverClass+"<br>");
		out.print("<b>userName</b> : " + userName+"<br>");
		out.print("<b>password</b> : " + password+"<br>");
//-------------------------------------------------------------------		
//		out.println("FirstServlet---service(HttpServletRequest request, HttpServletResponse response)---Hello World");
//-------------------------------------------------------------------		
		// raise new request
//		response.sendRedirect("https://www.google.com/");
//-------------------------------------------------------------------		
		// same request forward to another servlet/jsp
//		RequestDispatcher rd = request.getRequestDispatcher("ganesh");
//		rd.forward(request, response);
//		rd.include(request, response);
*/		
	}
}
