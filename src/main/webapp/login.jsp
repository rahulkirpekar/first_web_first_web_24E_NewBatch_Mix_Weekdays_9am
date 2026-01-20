<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Application</title>
</head>
<body>
	<h3>${logoutsuccess}</h3>
	<h3>${invalidAccess}</h3>
	
	<form action="loginServlet" method="post">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>