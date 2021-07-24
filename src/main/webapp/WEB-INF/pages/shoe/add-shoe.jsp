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
			<h2 class="mb-4">${shoe.getShoeName()} Details</h2>
			<form:form action="${submitUri}" method="post" modelAttribute="shoe">
				<div class="row mb-4">
					<div class="col-2">
						<label for="shoeName" class="form-label">Shoe Name</label>
					</div>
					<div class="col-4">
						<form:input path="shoeName" class="form-control" /> 
					</div>
				</div>
				<div class="row mb-4">
					<div class="col-2">
						<label for="shoeCategory" class="form-label">Shoe Category</label>	
					</div>
					<div class="col-4">
						<form:select path="shoeCategory" class="form-select" >
							<form:options items="${shoeCategories}"/>
						<!--
							<option selected>${shoe.getShoeCategory()}</option>
							 foreach possible category, need List<Category>
							<c:forEach var="shoeCategory" items="${shoeCategories}" >
								<option value="${shoeCategory}">${shoeCategory}</option>
							</c:forEach>
							 -->
						</form:select>
					</div>
				</div>
				<div class="row mb-4">
					<div class="col-2">
						<label for="shoePrice" class="form-label">Shoe Price</label>
					</div>
					<div class="col-4">
						<form:input path="shoePrice" type="number" min="1" step="any" class="form-control" />
					</div>
				</div>
				<div class="row mb-4">
					<div class="col-2">
						<button type="submit" class="btn btn-primary">Add Shoe</button>
					</div>
				</div>
			</form:form>
		</div>
	</body>
</html>