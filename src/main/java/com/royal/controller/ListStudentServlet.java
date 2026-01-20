package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ListStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
			StudentDao dao = new StudentDao();
			ArrayList<StudentBean> list = dao.getAllRecords();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("studlist.jsp").forward(request, response);
		}
	}
}
