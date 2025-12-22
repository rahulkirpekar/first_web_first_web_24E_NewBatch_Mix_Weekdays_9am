package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;
import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet
{
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	int id=0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// MIME
		response.setContentType("text/html");
		
		String  fullname= request.getParameter("fullname");
		String  ageStr     = request.getParameter("age");
		String  course  = request.getParameter("course");
		String  gender  = request.getParameter("gender");
		String  hobbies[]   = request.getParameterValues("hobby");
		
//		for (int i = 0; i < hobbies.length; i++) 
//		{
//			System.out.println("hobbies["+i+"] : " + hobbies[i]);
//		}
		
		String  dob     = request.getParameter("dob");
		String  email   = request.getParameter("email");
		String  mobile  = request.getParameter("mobile");
		String  address = request.getParameter("address");

		// Backend Validation
		
		StudentBean sbean = new StudentBean();
		
		boolean flag = false;
		
		if(StringUtils.isValidString(fullname)) 
		{
			sbean.setFullname(fullname);
		}else 
		{
			flag = true;
			request.setAttribute("fullnameError", "<font color='red'>Please enter valid FullName.</font>");
		}
		
		if(StringUtils.isValidString(ageStr)) 
		{
			sbean.setAge(Integer.parseInt(ageStr));
		}else 
		{
			flag = true;
			request.setAttribute("ageError", "<font color='red'>Please enter valid Age.</font>");
		}
		
		if(StringUtils.isValidString(course)) 
		{
			sbean.setCourse(course);
		}else 
		{
			flag = true;
			request.setAttribute("courseError", "<font color='red'>Please enter valid Course.</font>");
		}
		
		
		if(StringUtils.isValidString(gender)) 
		{
			sbean.setGender(gender);
		}else 
		{
			flag = true;
			request.setAttribute("genderError", "<font color='red'>Please enter valid Gender.</font>");
		}		
		
		if(hobbies != null) 
		{
			sbean.setHobbies(hobbies);
		}else 
		{
			flag = true;
			request.setAttribute("hobbiesError", "<font color='red'>Please enter valid Hobbies.</font>");
		}		
		
		
		if(StringUtils.isValidString(dob)) 
		{
			sbean.setDob(dob);
		}else 
		{
			flag = true;
			request.setAttribute("dobError", "<font color='red'>Please enter valid DOB.</font>");
		}	
		
		if(StringUtils.isValidString(email)) 
		{
			sbean.setEmail(email);
		}else 
		{
			flag = true;
			request.setAttribute("emailError", "<font color='red'>Please enter valid Email.</font>");
		}	
		  

		if(StringUtils.isValidString(mobile)) 
		{
			sbean.setMobile(mobile);
		}else 
		{
			flag = true;
			request.setAttribute("mobileError", "<font color='red'>Please enter valid Mobile.</font>");
		}	
		 
		if(StringUtils.isValidString(address)) 
		{
			sbean.setAddress(address);
		}else 
		{
			flag = true;
			request.setAttribute("addressError", "<font color='red'>Please enter valid Address.</font>");
		}
		
		request.setAttribute("sbean", sbean);
		
		RequestDispatcher rd = null;
		if(flag) 
		{
			rd = request.getRequestDispatcher("studentregi.jsp");
			
		}else 
		{
			StudentDao dao = new StudentDao();
			
			int rowsAffected = dao.insertStudent(sbean);
			
			if(rowsAffected > 0) 
			{
				rd = request.getRequestDispatcher("ListStudentServlet");
				
			}else 
			{
				request.setAttribute("dberror", "<font color='red'>Database ServerDown</font>");
				rd = request.getRequestDispatcher("studentregi.jsp");
			}
			
		}
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
