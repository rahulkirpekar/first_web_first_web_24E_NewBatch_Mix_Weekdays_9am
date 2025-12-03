package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.Student;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		Student s = (Student)session.getAttribute("rahulInfo");

		out.println("ThirdServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
		
		
//		ServletContext applicationScope = getServletContext();
		
//		Student s= (Student)applicationScope.getAttribute("rahul");
//		System.out.println("ThirdServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
		
		
//		PrintWriter out = response.getWriter();
//		Student s = (Student)request.getAttribute("rahul");
//		System.out.println("ThirdServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
//		System.out.println("request : " + request);
//		System.out.println("response : " + response);
//		System.out.println("service() : " + this);
//		System.out.println("--------------------------------------------");
	}
	@Override
	public void destroy() 
	{
		System.out.println("destroy() : " + this);		
	}
}
