<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=ISO-8859-1">
<script src='js/nav.js' type='text/javascript'></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"> </script>
</head>
<body>

	<header> <nav class="navbar navbar-inverse">  
	<div class="container-fluid">
		   
		<div class="navbar-header">
			      <a class="navbar-brand" href="../BigBoxWeb2/welcome.jsp">BigBox
				App</a>    
		</div>
		    
		<ul class="nav navbar-nav">
			      
			<li><a href="../BigBoxWeb2/listAllStoresServlet">ALL STORES</a></li>
			     
			<li><a href="../BigBoxWeb2/StoresByDivisionServlet ">STORES
					BY DIVISION</a></li>
			<li><a href="../BigBoxWeb2/AddStores.jsp">ADD STORE</a></li>
			<li><a href="../BigBoxWeb2/UpdateStores.jsp">UPDATE STORE</a></li>
			<li><a href="../BigBoxWeb2/DeleteStores.jsp">DELETE STORE</a></li>
			<li><a href="../BigBoxWeb2/AllDivisionsServlet">ALL
					DIVISIONS</a></li>
			<li><a href="../BigBoxWeb2/AddDivisions.jsp">ADD DIVISION</a></li>
			<li><a href="../BigBoxWeb2/DeleteDivisions.jsp">DELETE
					DIVISION</a></li>
			<li><a href="../BigBoxWeb2/SalesServlet">SALES</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			      
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					${sessionScope.user.userName}</a></li>      
			<li><a href="#"><span class="glyphicon glyphicon-log-out"
					name="exit" value="logOut"></span> Exit</a></li>     
		</ul>
		 
	</div>
	</nav> </header>

</body>
</html>