<%@page import="in.arunangshu.dao.cartDaoImpl"%>
<%@page import="in.arunangshu.dao.ICartDao"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%
DecimalFormat dcf = new DecimalFormat("#.##");
ICartDao dao=null;
dao=new cartDaoImpl();
User u=(User)session.getAttribute("auth");
List<cartOutput> cart_list=null;
int b=0;
if(u!=null){
	cart_list=dao.showCart(u.getId());
	session.setAttribute("total", cart_list.size());
}
else{
	response.sendRedirect("login.jsp");
}


%> 
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<%@include file="includes/important.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
	<div class="container my-3">
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (cartOutput c : cart_list) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%= dcf.format(c.getPrice()) %></td> 
					<% b+=Integer.parseInt(dcf.format(c.getPrice())); %>
					<td>
						<form action="buy-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value=<%=c.getQty()%> readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</div>
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
		
		
		<div class="d-flex py-3"><h3>Total Price: $ <%= b %> </h3> <a class="mx-3 btn btn-danger" href="cart-check-out">Check Out <i class="fa fa-arrow-right"></i> </a></div>
	</div>
</body>
</html>