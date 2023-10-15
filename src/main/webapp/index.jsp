<%@page import="in.arunangshu.dao.productDaoImpl"%>
<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="in.arunangshu.dao.IProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Base64"%>
	
<%
IProductDao pd = new productDaoImpl();
List<Product> products = pd.getAllProduct();
/* ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
} */
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Bazaar</title>

<%@include file="includes/important.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
						 <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(p.getImage()) %>" alt="Image">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: $<%=p.getPrice() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-outline-success" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a> 							<a class="btn btn-success" href="buy-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div> 


</body>
</html>