<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Enter organization id:
		<form action="/auth/findorganizationbyid.html" method= "post">
		<table>
			<tr><td>Organization ID</td>				
				<td><input type = "number" name ="id"/><div>${id }</div>
				</tr>
			<tr><input type = "submit"/></tr>
		</table>
		</form>

</body>
</html>