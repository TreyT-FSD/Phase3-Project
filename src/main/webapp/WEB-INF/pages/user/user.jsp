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
	<a href='/user/logout'>Logout</a>
	<c:if test="${loggedInUserMsg != null && loggedInUserMsg.length() != 0}">${loggedInUserMsg}</c:if>
	
	
	
	</body>
</html>