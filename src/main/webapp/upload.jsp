<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="includes/important.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<center>
		<u><h1 class="display1">Upload a Product</h1></u>
	</center>
	<form action="uploadProduct" method="post" enctype="multipart/form-data">
		<div class="container m-5 ">
			<div class="row">
				<div class="col">
					<div class="form-floating">
						<input type="text" class="form-control" id="floatingInputValue"
							placeholder="name" name="name"> <label
							for="floatingInputValue">Product name</label>
					</div>
				</div>
				<div class="col">
					<div class="form-floating">
						<input type="text" class="form-control" id="floatingInputValue"
							placeholder="Price" name="price"> <label
							for="floatingInputValue">Product price</label>
					</div>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col">
					<div class="form-floating mt-4">
						<input type="text" class="form-control" id="floatingInputValue"
							placeholder="Category" name="category"> <label
							for="floatingInputValue">Product Category</label>
					</div>
				</div>
				<div class="col">
					<div>
						<label for="formFileLg" class="form-label">Image input</label> <input
							class="form-control form-control-lg" id="formFileLg" type="file"
							accept=".png, .jpg, .jpeg, image/png, image/jpeg"
							name="imageFile">
					</div>
				</div>
			</div>
		</div>
		<div class="container position-relative m-3">
				<button type="submit"
					class="position-absolute top-0 end-0 btn btn-outline-success">Submit</button>
				<button type="reset"
					class="position-absolute btn btn-outline-danger">Home</button>
			</div>
	</form>


</body>
</html>