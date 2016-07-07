
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

     <!-- Custom CSS -->
        <link href="css/style.css" rel="stylesheet">
<style>
        p{
        	font-size:50px;
        }
</style>
</head>
<body>
<!-- 	<div class="container">  -->
<%-- 			<h1>Welcome... <c:out value = "${hostelName}"/></h1> --%>
		
<%-- 			<c:forEach items = "${BlockNames }" var = "block"> --%>
			
<%-- 				<h2> ${block.value} </h2> --%>
			
<%-- 			</c:forEach> --%>
<!-- 	</div> -->
<!-- 	<table align="center" width="50%"> -->
<!-- 		<tr> -->
<!-- 			<td><a href="http://localhost:8080/MyProject/register.html">Add Student</a></td><td><a href="http://localhost:8080/MyProject/totalStudents.html">Display Students</a></td> -->
<!-- 		</tr> -->
<!-- 		<tr><td><a href="http://localhost:8080/MyProject/balanceStudents.html">Due Student</a></td><td><a href="http://localhost:8080/MyProject/vacancies.html">Empty</a></td></tr> -->
<!-- 	</table> -->
	
	
        <!-- Start Logo Section -->
        <section id="logo-section" class="text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="logo text-center">
                            <h1><c:out value = "${hostelName}"/></h1>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Logo Section -->
        
        
        <!-- Start Main Body Section -->
        <div class="mainbody-section text-center">
            <div class="container">
                <div class="row">
                    
                    <div class="col-md-6">
                        
                        <div class="menu-item blue">
                            <a href="#">
                                <br><br>
                                <p style="font-size:50px">New</p>
                                <br><br>
                            </a>
                        </div>
                        
                        <div class="menu-item green">
                            <a href="#">
								<br><br>
                                <p style="font-size:50px">Update</p>
                                <br><br>
                            </a>
                        </div>
                        
                        <div class="menu-item light-red">
                            <a href="#">
								<br><br>
                                <p style="font-size:50px">Pay</p>
                                <br><br>
                            </a>
                        </div>
                        
                    </div>
                    <div class="col-md-6">
                        
                        <div class="menu-item light-red">
                            <a href="#">
								<br><br>
                                <p style="font-size:50px">Vacant</p>
                                <br><br>
                            </a>
                        </div>
                        
                        <div class="menu-item color">
                            <a href="#">
								<br><br>
                                <p style="font-size:50px">Leaving</p>
                                <br><br>
                            </a>
                        </div>
                        
                        <div class="menu-item blue">
                            <a href="#">
								<br><br>
                                <p style="font-size:50px">All</p>
                                <br><br>
                            </a>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
</body>
</html>