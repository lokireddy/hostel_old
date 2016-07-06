
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="container"> 
			<h1>Welcome... <c:out value = "${hostelName}"/></h1>
		
			<c:forEach items = "${BlockNames }" var = "block">
			
				<h2> ${block.value} </h2>
			
			</c:forEach>
	</div>
	<table align="center" width="50%">
		<tr>
			<td><a href="http://localhost:8080/MyProject/register.html">Add Student</a></td><td><a href="http://localhost:8080/MyProject/totalStudents.html">Display Students</a></td>
		</tr>
		<tr><td><a href="http://localhost:8080/MyProject/balanceStudents.html">Due Student</a></td><td><a href="http://localhost:8080/MyProject/vacancies.html">Empty</a></td></tr>
	</table>
</body>
</html>