<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FullName</th>
			<th>Age</th>
			<th>Course</th>
			<th>Gender</th>
			<th>Hobbies</th>
			<th>DOB</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Address</th>
		</tr>
		<%
			for(int i = 0 ; i < list.size();i++)
			{
				StudentBean s = list.get(i);
		%>	
				<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getFullname()%></td>
					<td><%=s.getAge()%></td>
					<td><%=s.getCourse()%></td>
					<td><%=s.getGender()%></td>
					<td><%=s.getHobbies()%></td>
					<td><%=s.getDob()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getMobile()%></td>
					<td><%=s.getAddress()%></td>
				</tr>		
		<% 	
			}
		%>
	</table>
</body>
</html>
