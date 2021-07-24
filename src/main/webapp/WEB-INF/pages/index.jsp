<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sporty Shoes</title>
	</head>
	<body>
		<%@ include file="nav.jsp" %>
		<div class="container">
			<div class="row row-cols-1 row-cols-md-3 g-4">
			  <c:forEach var="shoe" items="${shoes}" >
			    <div class="col">
			      <div class="card">
			        <!-- <img src="..." class="card-img-top" alt="...">  -->
			        <div class="card-body">
			          <h5 class="card-title">${shoe.getShoeName()}</h5>
			          <p class="card-text">Price: ${shoe.getShoePrice()}</p>
			          <p class="card-text">Category: ${shoe.getShoeCategory()}</p>
			        </div>
			      </div>
			    </div>
			  </c:forEach>
			</div>
		</div>
	</body>
</html>