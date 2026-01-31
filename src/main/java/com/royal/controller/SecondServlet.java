package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import com.royal.bean.Student;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		PrintWriter out = response.getWriter();
		
		System.out.println("====SecondServlet : service(HttpServletRequest request, HttpServletResponse response)====");
		
//		HttpSession session = request.getSession(false);
//		Student s = (Student)session.getAttribute("rahulInfo");
//		out.println("SecondServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
//		session.removeAttribute("rahulInfo");
		

//		ServletContext applicationScope = getServletContext();
//		Student s= (Student)applicationScope.getAttribute("rahul");
//		System.out.println("SecondServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
		
/*		
		Student s = (Student)request.getAttribute("rahul");
		System.out.println("SecondServlet : " + s.getId()+" " + s.getFullname()+" " + s.getAge());
		request.removeAttribute("rahul");
		request.getRequestDispatcher("thirdServlet").forward(request, response);
 * -----------------------------------------------------------------------------------------
		ServletContext context	= getServletContext();
		
		String lang1 = context.getInitParameter("lang1");
		String lang2 = context.getInitParameter("lang2");
		String lang3 = context.getInitParameter("lang3");
		String lang4 = context.getInitParameter("lang4");

		out.print("<b>lang1</b> : " + lang1+"<br>");
		out.print("<b>lang2</b> : " + lang2+"<br>");
		out.print("<b>lang3</b> : " + lang3+"<br>");
		out.print("<b>lang4</b> : " + lang4+"<br>");
		
		// get Servlet Config object
		
		ServletConfig config = getServletConfig();
		
		Enumeration<String>e = config.getInitParameterNames();
		
		while (e.hasMoreElements()) 
		{
			String paramName = (String) e.nextElement();

			String paramValue = config.getInitParameter(paramName);

			out.print("<b>"+paramName+"</b> : " + paramValue+"<br>");
		}
		System.out.println("SecondServlet config : " + config);
		
		String urlName = config.getInitParameter("URLNAME");
		String driverClass = config.getInitParameter("DRIVERCLASS");
		String userName = config.getInitParameter("USERNAME");
		String password = config.getInitParameter("PASSWORD");
		
		out.print("<b>urlName</b> : " + urlName+"<br>");
		out.print("<b>driverClass</b> : " + driverClass+"<br>");
		out.print("<b>userName</b> : " + userName+"<br>");
		out.print("<b>password</b> : " + password+"<br>");
*/	}
}
