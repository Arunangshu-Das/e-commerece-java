<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		if(request.getSession().getAttribute("auth")!=null){
			response.sendRedirect("index.jsp");
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@include file="includes/important.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
	<center>
		<u>
			<p class="m-5 fs-1">Login</p>
		</u>
	</center>
	<div class="container mt-5">
		<form action="user-login" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" name="login-email"
					placeholder="Enter your email" required="required">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1" name="login-password"
					placeholder="Enter your password">
			</div>
			<div class="position-relative m-3">
				<button type="submit"
					class="position-absolute top-0 end-0 btn btn-outline-success">Submit</button>
				<button type="reset"
					class="position-absolute top-0 btn btn-outline-danger">Home</button>
			</div>
		</form>
	</div>
</body>
</html>