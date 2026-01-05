package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
