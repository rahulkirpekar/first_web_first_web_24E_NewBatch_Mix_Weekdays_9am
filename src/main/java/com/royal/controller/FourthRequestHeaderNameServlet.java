package com.royal.controller;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FourthRequestHeaderNameServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Enumeration<String> e = request.getHeaderNames();
		
		while (e.hasMoreElements()) 
		{
			String headerName = (String) e.nextElement();

			String headerValue = request.getHeader(headerName);

			System.out.println(headerName + " : " + headerValue);
		}
	}
}