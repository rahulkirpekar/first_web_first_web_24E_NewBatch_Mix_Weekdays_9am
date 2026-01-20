package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EditStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		String userName = (String)session.getAttribute("userName");
		
		if ( (session == null) || (userName == null))
		{
			request.setAttribute("invalidAccess", "<font color ='green'> Invalid Access...!</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else 
		{ 
				
			int id = Integer.parseInt(request.getParameter("id"));
			
			StudentDao dao = new StudentDao();
	
			StudentBean sbean = dao.getStudentByid(id);
			
			RequestDispatcher rd = null;
			
			if(sbean == null) 
			{
				rd = request.getRequestDispatcher("ListStudentServlet");
			}
			else 
			{
				request.setAttribute("sbean", sbean);
				rd = request.getRequestDispatcher("editstudent.jsp");			
			}
			
			rd.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
