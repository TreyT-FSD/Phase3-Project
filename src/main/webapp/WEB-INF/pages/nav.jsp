<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link
		    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		    rel="stylesheet"
		    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		    crossorigin="anonymous">
	</head>
	<body>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/">Sporty Shoes</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarCollapse">
		      <ul class="navbar-nav me-auto mb-2 mb-md-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/">Home</a>
		        </li>
		        <li class="nav-item">
		          <c:if test="${!userAuthenticated}"><a class="nav-link active" href="/user/">User Sign-in</a></c:if>
		          <c:if test="${userAuthenticated}"><a class="nav-link active" href="/user/">User Homepage</a></c:if>
		        </li>
		        <li class="nav-item">
		          <c:if test="${!adminAuthenticated}"><a class="nav-link active" href="/admin/">Admin Sign-in</a></c:if>
				  <c:if test="${adminAuthenticated}"><a class="nav-link active" href="/admin/">Admin Homepage</a></c:if>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>		
	<!-- get bootstrap js to make this responsive -->
	<script 
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
		crossorigin="anonymous">
	</script>
	</body>
</html>