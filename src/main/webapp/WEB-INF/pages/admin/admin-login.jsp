<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sporty Shoes - Admin Login</title>
	</head>
	<body>
	<%@ include file="nav.html" %>
	Admin Login Page
	
	<!-- a login form goes here. put a little box below it with the default creds -->
	<div class="container">
	
		<div class="card" style="width: 18rem;">
			<div class="card-header">Admin Login Registration</div>
			
			<form:form action="adminLogin" method="post" modelAttribute="adminObj" >
			
				<div class="form-group">
					<label for="adminUsername">User Name</label>
					<form:input path="adminUsername" cssClass="form-control"/>
					<!-- path is the property from the user class that this value should be stored in -->
				</div>
				
				<div class="form-group">
					<label for="adminPwd">password</label>
					<form:input path="adminPwd" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<form:button cssClass="btn btn-sucess">Submit</form:button>
				</div>
			
			</form:form>
			<c:if test="${adminLoginMsg != null && adminLoginMsg.length() != 0}">${adminLoginMsg}</c:if>
			
		</div>
	</div>
	</body>
</html>