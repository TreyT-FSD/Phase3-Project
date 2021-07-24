<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<title>Sporty Shoes - Admin</title>
	</head>
	<body>
		<%@ include file="../nav.jsp" %>
		<div class="container">
		<form:form action="changeAdminPassword" method="post" modelAttribute="admin">
			<form:hidden path="adminId" />
			<label for=adminPwd>Change Admin Password:</label>
	  		<form:input type="password" path="adminPwd" required="required"/>
	  		<form:button cssClass="btn btn-sucess">Submit</form:button>&nbsp;<c:if test="${passwordActionMsg != null && passwordActionMsg.length() != 0}">${passwordActionMsg}</c:if>
		</form:form>
		<a href='/admin/logout'>Logout</a>
		<br>
		<br>
			<h2>Shoes</h2>
			<a href='/shoe/add'>Add New Shoe</a>
			<table class="table table-striped table-hover">
			  <thead>
				<tr>
				  <th scope="col">Shoe Id</th>
				  <th scope="col">Shoe Name</th>
				  <th scope="col">Shoe Category</th>
				  <th scope="col">Shoe Price</th>
				  <th scope="col">Edit Shoe</th>
				  <th scope="col">Remove Shoe</th>
				</tr>
			  </thead>
			  <tbody>
			    <c:forEach var="shoe" items="${shoes}">
				<tr>
					<td scope="row">${shoe.getShoeId()}</td>
					<td scope="row">${shoe.getShoeName()}</td>
					<td scope="row">${shoe.getShoeCategory()}</td>         			
					<td scope="row">
						<!-- https://www.tutorialspoint.com/how-to-format-currencies-in-jsp -->
						<c:set var="theShoePrice" value="${shoe.getShoePrice()}" />
						<fmt:setLocale value = "en_US"/>
						<fmt:formatNumber value = "${theShoePrice}" type = "currency"/>
					</td>
					<td scope="col"><a href="/shoe/${shoe.getShoeId()}">Edit</a></td>
					<td scope="col"><a href="/shoe/delete/${shoe.getShoeId()}">Delete</a></td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
			<br>
			<h2>Users</h2>
			<input class="form-control" id="userSearch" type="text" placeholder="Search Users">
			<table class="table table-striped table-hover">
			  <thead>
			  <tr>
				  <th scope="col">User Id</th>
				  <th scope="col">User First Name</th>
				  <th scope="col">User Last Name</th>
				  <th scope="col">User Email</th>
				</tr>
			  </thead>
			  <tbody id="userTable">
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
	<script>
		$(document).ready(function(){
		  $("#userSearch").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#userTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
</html>