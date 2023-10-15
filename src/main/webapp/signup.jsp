<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-up to The Bazzar</title>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	<center>
	<u><h1 class="diaplay1 mt-4">The Bazzar</h1></u></center>
	
	<form action="new-user" method="post">
		<div class="container">
		  <div class="mt-3 row g-3">
			  <div class="col">
			  <label for="exampleInputEmail1" class="form-label">First name</label>
			    <input type="text" class="form-control" placeholder="First name" name="fname" aria-label="First name" required>
			  </div>
			  <div class="col">
			  	<label for="exampleInputEmail1" class="form-label">Last name</label>
			    <input type="text" class="form-control" placeholder="Last name" name="lname" aria-label="Last name" required>
			  </div>
			</div>
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email address</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email Address" name="emails" required>
		    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password" name="pass" required>
		  </div>
		  <div class="mb-3 form-check">
		    <input type="checkbox" class="form-check-input" id="exampleCheck1" onclick="validateCheckbox()">
		    <label class="form-check-label" for="exampleCheck1" for="exampleCheck1"> <a href="policy.jsp"> I agree to The Bazzar's privacy policy</a></label>
		  </div>
		  <button type="submit" class="btn btn-primary" disabled>Submit</button>
		 </div>
	</form>
	
	
	
	
	<script>
	function validateCheckbox() {
	    var checkbox = document.getElementById("exampleCheck1");
	    var submitButton = document.querySelector("button[type=submit]");
	
	    if (checkbox.checked) {
	        submitButton.disabled = false;
	    } else {
	        submitButton.disabled = true;
	    }
	}
	</script>
	
	
</body>
</html>