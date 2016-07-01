<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<title>Insert title here</title>
</head>
<body>
<form:form action="#" method="GET" commandName="registrationFormCommand">
</form:form>

  	<table align="center" style="border:1px solid #666; width: 50%;">
 		<thead>
	 		<tr><td><a href="sort.html?id=id" id="id" class="sort">NAME</a></td>
		 		<td><a href="sort.html?id=name" id="name" class="sort">MOBILE</a></td>
		 		<td><a href="sort.html?id=age" id="age" class="sort">ROOM</a></td>
		 		<td><a href="sort.html?id=salary" id="salary" class="sort">FEE</a></td>
		 		<td><a href="sort.html?id=dept" id="dept" class="sort">JOIN_DATE</a></td>
		 		<td>ACTION</td>
		 		<td>ACTION</td>
	 		</tr>
 		</thead>
<!--  		<tr><th>ID</th> -->
<!--  			<th>NAME</th> -->
<!--  			<th>AGE</th> -->
<!--  			<th>SALARY</th> -->
<!--  			<th>DEPARTMENT</th> -->
<!--  			<th>ACTION</th> -->
<!--  			<th>ACTION</th>	 	 -->
<!--   		</tr> -->
<c:if test="${!empty total.studentList}">
  	<c:forEach items="${total.studentList}" var="student">
  	
  	<tr>
  	
  		<td align="justify"><c:out value="${student.name}"/></td>
  		<td align="justify"><c:out value="${student.mobile}"/></td>
  		<td align="justify"><c:out value="${student.room}"/></td>
  		<td align="justify"><c:out value="${student.fee}"/></td>
  		<td align="justify"><c:out value="${student.join_date}"/></td>
  		<td align="justify"><a href="update.html?id=${student.mobile}">UPDATE</a></td>
  		<td align="justify"><a href="delete.html?id=${student.mobile}">DELETE</a></td>
  	</tr>
 
  	</c:forEach>
  	</c:if>
  	</table>
  	
</body>
</html>