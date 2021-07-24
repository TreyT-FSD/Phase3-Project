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
	<%@ include file="../nav.jsp" %>
	
	<div class="container">
	<h2>${shoe.getShoeName()} Details</h2>
		<form:form action="updateShoe" method="post" modelAttribute="shoe" class="">
			<div class="col">
				<label for="shoeName" class="col-sm-2 col-form-label">Shoe Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id=shoeName> 
				</div>
			</div>
			<div class="col">
				<label for="shoeCategory" class="col-sm-2 col-form-label">Shoe Category</label>
				<select class="form-select" id="shoeCategory">
					<option selected>Choose...</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
				</select>
			</div>
			<div class="col">
				<label for="shoePrice" class="col-sm-2 col-form-label">Shoe Price</label>
				<div class="col-sm-10">
					<input type="number" min="1" step="any" class="form-control" id="shoePrice">
				</div>
			</div>
			<div class="col">
			<br>
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Update Shoe</button>
				</div>
			</div>
		</form:form>
		</div>
	</body>
</html>