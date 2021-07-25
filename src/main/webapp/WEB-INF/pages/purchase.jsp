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
	<%@ include file="nav.jsp" %>
		<div class="container">
			<div class="card mb-3" style="max-width: 540px;">
			  <div class="row g-0">
			    <div class="col-md-4">
			      <img src="/images/shoes/shoe.png" class="img-fluid rounded-start" alt="${shoe.getShoeName() }">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">${order.getOrderShoe().getShoeName()}</h5>
			        <p class="card-text">Price: $${order.getOrderShoe().getShoePrice()}</p>
			        <form:form action="${submitUri}" method="post" modelAttribute="order">
			        	<form:hidden path="orderCustomer"/>
			        	<form:hidden path="orderShoe"/>
			        	<form:hidden path="orderTimeStamp"/>
			        	<button type="submit" class="btn btn-primary">Purchase</button>
			      	</form:form>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</body>
</html>
