<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home Page</title>
</head>
<body>
	<h1>First Jsp Page</h1>
	
	
	<%
		int no = 5;
		for(int i = 1; i<=10 ; i++)
		{
			out.print(no + " * " + i +" = " + (no*i)+"<br>");	 
		}
	%>
	Date is : <%=new Date()%>	
</body>
</html>
