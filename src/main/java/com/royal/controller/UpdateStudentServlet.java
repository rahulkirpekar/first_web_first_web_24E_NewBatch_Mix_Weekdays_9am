package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;
import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("UpdateStudentServlet : service()");
	
		HttpSession session = request.getSession(false);
		String userName = (String)session.getAttribute("userName");
		
		if ( (session == null) || (userName == null))
		{
			request.setAttribute("invalidAccess", "<font color ='green'> Invalid Access...!</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else 
		{ 
			// MIME
			response.setContentType("text/html");
			int  id = Integer.parseInt(request.getParameter("id"));		
			String  fullname= request.getParameter("fullname");
			String  ageStr     = request.getParameter("age");
			String  course  = request.getParameter("course");
			String  gender  = request.getParameter("gender");
			String  hobbies[]   = request.getParameterValues("hobby");
			
	//				for (int i = 0; i < hobbies.length; i++) 
	//				{
	//					System.out.println("hobbies["+i+"] : " + hobbies[i]);
	//				}
			
			String  dob     = request.getParameter("dob");
			String  email   = request.getParameter("email");
			String  mobile  = request.getParameter("mobile");
			String  address = request.getParameter("address");
	
			// Backend Validation
			
			StudentBean sbean = new StudentBean();
			
			sbean.setId(id);
			
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
				rd = request.getRequestDispatcher("editstudent.jsp");
				
			}else 
			{
				StudentDao dao = new StudentDao();
				
				int rowsAffected = dao.updateStudent(sbean, id);
				
				if(rowsAffected > 0) 
				{
					rd = request.getRequestDispatcher("ListStudentServlet");
					
				}else 
				{
					request.setAttribute("dberror", "<font color='red'>Database ServerDown</font>");
					rd = request.getRequestDispatcher("editstudent.jsp");
				}
				
			}
			rd.forward(request, response);
		}
	}
}
