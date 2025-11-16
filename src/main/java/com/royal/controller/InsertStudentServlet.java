package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.royal.bean.StudentBean;

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
		int  age     = Integer.parseInt(request.getParameter("age"));
		String  course  = request.getParameter("course");
		String  gender  = request.getParameter("gender");
		String  hobbies[]   = request.getParameterValues("hobby");
		
		for (int i = 0; i < hobbies.length; i++) 
		{
			System.out.println("hobbies["+i+"] : " + hobbies[i]);
		}
		
		String  dob     = request.getParameter("dob");
		String  email   = request.getParameter("email");
		String  mobile  = request.getParameter("mobile");
		String  address = request.getParameter("address");
 
		PrintWriter out = 	response.getWriter();
		
		out.print("<br>");
		
		id = id+1;
		
		StudentBean s = new StudentBean(id, fullname, age, course, gender, hobbies, dob, email, mobile, address);
		
		list.add(s);
		
		out.print("<table border='1'>");
		out.print("	<tr>                    ");
		out.print("		<td>Id</td>         ");
		out.print("		<td>FullName</td>   ");
		out.print("		<td>Age</td>        ");
		out.print("		<td>Course</td>     ");
		out.print("		<td>Gender</td>     ");
		out.print("		<td>Hobbies</td>    ");
		out.print("		<td>DOB</td>        ");
		out.print("		<td>Email</td>      ");
		out.print("		<td>Mobile</td>     ");
		out.print("		<td>Address</td>    ");
		out.print("	</tr>                   ");

		for(int i = 0 ;i < list.size();i++) 
		{
			s = list.get(i);
			out.print("	<tr>                    ");
			out.print("		<td>"+s.getId()+"</td>           ");
			out.print("		<td>"+s.getFullname()+"</td>           ");
			out.print("		<td>"+s.getAge()+"</td>           ");
			out.print("		<td>"+s.getCourse()+"</td>           ");
			out.print("		<td>"+s.getGender()+"</td>           ");
			
			String h[] = s.getHobbies();
			
			String hobbiesValue = "";
			for (int j = 0 ; j < h.length;j++) 
			{
				if(j < (h.length-1)) 
				{
					hobbiesValue = hobbiesValue + h[j] +",";
				}else 
				{
					hobbiesValue = hobbiesValue + h[j] +".";
				}
			}
			out.print("		<td>"+hobbiesValue+"</td>           ");
			out.print("		<td>"+s.getDob()+"</td>           ");
			out.print("		<td>"+s.getEmail()+"</td>           ");
			out.print("		<td>"+s.getMobile()+"</td>           ");
			out.print("		<td>"+s.getAddress()+"</td>           ");
			out.print("	</tr>                   ");
		}
		out.print("</table>					");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
