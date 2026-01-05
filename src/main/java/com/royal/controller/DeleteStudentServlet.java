package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;a
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.deleteStudent(id);
		
		RequestDispatcher rd = null;
		
		if (rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
		} else 
		{
			request.setAttribute("deleteError", "<font color='red'>Student record not deleted due to DB Error.</font>");
			rd = request.getRequestDispatcher("ListStudentServlet");
		}
		rd.forward(request, response);
		
		System.out.println("DeleteStudentServlet--id---"+id);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
