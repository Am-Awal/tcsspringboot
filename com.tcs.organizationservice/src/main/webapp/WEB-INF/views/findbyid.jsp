<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Enter employee id:
		<form action="/auth/findbyid.html" method= "post">
		<table>
			<tr><td>Employee ID</td>				
				<td><input type = "number" name ="id"/><div>${id }</div>
				</tr>
			<tr><input type = "submit"/></tr>
		</table>
		</form>
</body>
</html>