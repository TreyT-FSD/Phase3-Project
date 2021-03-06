<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sporty Shoes - User Login</title>
	</head>
	<body>
		<%@ include file="../nav.jsp" %>
		
		<div class="container">	
		<div class="card" style="width: 18rem;">
			<div class="card-header">User Login</div>
			
			<form:form action="/user/userLogin" method="post" modelAttribute="userObj" >
			
				<div class="form-group">
					<label for="userEmail">Email Address</label>
					<form:input path="userEmail" cssClass="form-control"/>
					<!-- path is the property from the user class that this value should be stored in -->
				</div>
				
				<div class="form-group">
					<label for="userPwd">Password</label>
					<form:password path="userPwd" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<form:button cssClass="btn btn-sucess">Submit</form:button>
				</div>
				
			</form:form>
			
			<c:if test="${userLoginMsg != null && userLoginMsg.length() != 0}">${userLoginMsg}</c:if>
			
			
			
		</div>
		<a class="nav-link active" href="/user/registration">Sign Up</a>
		
	</div>
	</body>
</html>