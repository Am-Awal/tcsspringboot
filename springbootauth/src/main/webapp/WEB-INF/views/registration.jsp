<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	This is Registration page.

	<table>
		<form action="/register/registration.html" method= "post">
			<tr>
				<td>FristName</td>
				<td><input type = "text" name ="firstName"/><div>${firstName }</div>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type = "text" name ="lastName"/><div>${lastName }</div>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type = "number" name ="mobile"/><div>${mobile }</div>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type = "text" name ="userName"/><div>${userName }</div>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type = "text" name ="password"/><div>${password }</div>
			</tr>
			<tr>
				<td><input type = "submit"/></td>
			</tr>
		</form>
	</table>
</body>
</html>