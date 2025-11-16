package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdServlet  extends HttpServlet
{
	@Override
	public void init() throws ServletException 
	{
		System.out.println("init() : " + this);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("request : " + request);
		System.out.println("response : " + response);
		System.out.println("service() : " + this);
		System.out.println("--------------------------------------------");
	}
	@Override
	public void destroy() 
	{
		System.out.println("destroy() : " + this);		
	}
}
