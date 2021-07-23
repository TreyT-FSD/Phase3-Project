<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sporty Shoes - Admin</title>
	</head>
	<body>
		<%@ include file="../nav.html" %>
		<a href='/admin/logout'>Logout</a>
		
		<div class="container">
			<h2>Shoes</h2>
			<table class="table table-striped table-hover">
			  <thead>
				<tr>
				  <th scope="col">Shoe Id</th>
				  <th scope="col">Shoe Name</th>
				  <th scope="col">Shoe Category</th>
				  <th scope="col">Shoe Price</th>
				</tr>
			  </thead>
			  <tbody>
			    <c:forEach var="shoe" items="${shoes}">
				<tr>
					<td scope="row">${shoe.getShoeId()}</td>
					<td scope="row">${shoe.getShoeName()}</td>
					<td scope="row">${shoe.getShoeCategory()}</td>
					<td scope="row">${shoe.getShoePrice()}</td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
			<br>
			<h2>Users</h2>
			<table class="table table-striped table-hover">
			  <thead>
				<tr>
				  <th scope="col">User Id</th>
				  <th scope="col">User First Name</th>
				  <th scope="col">User Last Name</th>
				  <th scope="col">User Email</th>
				</tr>
			  </thead>
			  <tbody>
			    <c:forEach var="user" items="${users}">
				<tr>
					<td scope="row">${user.getUserId()}</td>
					<td scope="row">${user.getUserFirstName()}</td>
					<td scope="row">${user.getUserLastName()}</td>
					<td scope="row">${user.getUserEmail()}</td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		
	</body>
</html>