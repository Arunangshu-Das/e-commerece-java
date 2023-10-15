<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Not Found</title>
    <%@include file="includes/important.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
    <div class="container text-center mt-5">
        <h1>User Not Found</h1>
        <p>We couldn't find the user you are looking for.</p>
        
        <div class="mt-4">
            <p>What would you like to do?</p>
            <a href="signup.jsp" class="btn btn-primary">Sign Up</a>
            <a href="login.jsp" class="btn btn-secondary">Log In Again</a>
        </div>
    </div>
</body>
</html>
