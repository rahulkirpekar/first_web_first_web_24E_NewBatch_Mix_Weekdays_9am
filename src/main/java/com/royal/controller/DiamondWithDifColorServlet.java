package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DiamondWithDifColorServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); 
		String[] colors = {
			    "AntiqueWhite",
			    "Aqua",
			    "Aquamarine",
			    "Azure",
			    "Beige",
			    "Bisque",
			    "Black",
			    "BlanchedAlmond",
			    "Blue",
			    "BlueViolet",
			    "Brown",
			    "BurlyWood",
			    "CadetBlue",
			    "Chartreuse",
			    "Chocolate",
			    "Coral",
			    "CornflowerBlue",
			    "Cornsilk",
			    "Crimson",
			    "Cyan",
			    "DarkBlue",
			    "DarkCyan",
			    "DarkGoldenRod",
			    "DarkGray",
			    "DarkGreen",
			    "DarkKhaki",
			    "DarkMagenta",
			    "DarkOliveGreen",
			    "DarkOrange",
			    "DarkOrchid",
			    "DarkRed",
			    "DarkSalmon",
			    "DarkSeaGreen",
			    "DarkSlateBlue",
			    "DarkSlateGray",
			    "DarkTurquoise",
			    "DarkViolet",
			    "DeepPink",
			    "DeepSkyBlue",
			    "DimGray",
			    "DodgerBlue",
			    "FireBrick",
			    "ForestGreen",
			    "Fuchsia",
			    "Gainsboro",
			    "Gold",
			    "GoldenRod",
			    "Gray",
			    "Green"
			};
		int l=0;
		PrintWriter out = response.getWriter(); 
		for (int i = 1; i <= 5; i++) 
		{
			for(int k = (5-i);k>=1;k--) 
			{
					out.print("&nbsp;&nbsp;"); 
			}
			for (int j = 1; j <=i; j++) 
			{
				out.print("<font color='"+colors[l++] +"'>*  </font>");
			}
			out.println("<br>");
		}
		for (int i = 4; i >=1; i--) 
		{
			for(int k = (5-i);k>=1;k--) 
			{
				out.print("&nbsp;&nbsp;"); 
			}
			for (int j = 1; j <=i; j++) 
			{
				out.print("<font color='"+colors[l++] +"'>*  </font>");
			}
			out.println("<br>");
		}
	}
}
