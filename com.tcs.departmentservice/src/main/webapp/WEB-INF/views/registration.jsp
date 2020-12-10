<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Enter employee details.

	<table>
		<form action="/register/addemployee.html" method= "post">
			<tr>
				<td>Employee Name</td>
				<td><input type = "text" name ="name"/><div>${name }</div>
			</tr>
			<tr>
				<td>Employee ID</td>
				<td><input type = "number" name ="id"/><div>${id }</div>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type = "number" name ="age"/><div>${age }</div>
			</tr>
			<tr>
				<td>Position</td>
				<td><input type = "text" name ="position"/><div>${position }</div>
			</tr>
		<!-- 	<tr>
				<td>Department Name</td>
				<td><input type = "text" name ="departmentName"/><div>${departmentName }</div>
			</tr>
			<tr>
				<td>Organization Name</td>
				<td><input type = "text" name ="organizationName"/><div>${organizationName }</div>
			</tr>  -->
			<tr>
				<td><input type = "submit"/></td>
			</tr>
		</form>
	</table>
</body>
</html>