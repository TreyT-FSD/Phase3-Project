<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SportyShoes</title>
	</head>
	<body>
	<%@ include file="../nav.html" %>
	
	<div class="container">
	
		<div class="card" style="width: 18rem;">
			<div class="card-header">User Registration</div>
			
			<form:form action="registerUser" method="post" modelAttribute="userObj" >
			
				<div class="form-group">
					<label for="userFirstName">First Name</label>
					<form:input path="userFirstName" cssClass="form-control"/>
					<!-- path is the property from the user class that this value should be stored in -->
				</div>
				
				<div class="form-group">
					<label for="userLastName">Last Name</label>
					<form:input path="userLastName" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="userEmail">Email</label>
					<form:input path="userEmail" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="userPwd">password</label>
					<form:input path="userPwd" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<form:button cssClass="btn btn-sucess">Submit</form:button>
				</div>
			
			</form:form>
			
		</div>
	</div>
	
	
	
	</body>
</html>