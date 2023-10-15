<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.arunangshu.model.*" %>
    
    <% 
		User auth=(User) request.getSession().getAttribute("auth"); 
		if(auth!=null){
			request.setAttribute("auth", auth);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-commerece</title>
<%@include file="important.jsp"%>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">The Bazaar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="d-flex" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="badge rounded-pill bg-danger">${total}</span></a></li>
					<% 
					if(auth!=null){%>
						<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
						<li class="nav-item"><a class="nav-link" href="upload.jsp">Sell-Product</a></li>
						<li class="nav-item"><a class="nav-link" href="user-logout">Logout</a></li>
					<% }
					else{%>
						<li class="nav-item"><a class="nav-link" href="signup.jsp">Signup</a></li>
						<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					<% }
					%>					
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>