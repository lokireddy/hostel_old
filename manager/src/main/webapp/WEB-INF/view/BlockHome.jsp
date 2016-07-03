<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Blocks Home</title>
	</head>
	<body>
		<div class="container"> 
			<h1>Welcome... <c:out value = "${hostelName}"/></h1>
		
			<c:forEach items = "${BlockNames }" var = "block">
			
				<a href = "#" class = "btn btn-primary btn-lg active btn-responsive" id = "${block.key}" role = "button"> ${block.value} </a>
			
			</c:forEach>
		</div>
		
		
		<%-- <h2 align="center">Welcome..  <c:out value="${hostelName}"/></h2> --%>
		<!-- 	<table align="center" width="50%"> -->
		<!-- 		<tr> -->
		<!-- 			<td><a href="http://localhost:8080/MyProject/showHome.html?blockId=b1">Block 1</a></td><td><a href="http://localhost:8080/MyProject/showHome.html?blockId=b2">Block 2</a></td> -->
		<!-- 		</tr> -->
		<!-- 		<tr><td><a href="http://localhost:8080/MyProject/showHome.html?blockId=b3">Block 3</a></td><td><a href="http://localhost:8080/MyProject/showHome.html?blockId=b4">Block 4</a></td></tr> -->
		<!-- 	</table> -->
	</body>
</html>