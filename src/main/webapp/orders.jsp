<%@page import="in.arunangshu.dao.OrderDaoImpl"%>
<%@page import="in.arunangshu.dao.IOrderDao"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.time.LocalDateTime,java.time.format.DateTimeFormatter" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
DecimalFormat dcf = new DecimalFormat("#.##");
IOrderDao dao=null;
dao=new OrderDaoImpl();
User u=(User)session.getAttribute("auth");
List<OrderOutput> order_list=null;
if(u!=null){
	order_list=dao.showOrder(u.getId());
}
else{
	response.sendRedirect("login.jsp");
}


%>   
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Order</title>
<%@include file="includes/important.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(order_list != null){
				for(OrderOutput o:order_list){ %> 
					<tr>
					<% 
						String originalDateTimeString= String.valueOf(o.getCreationdate());
						LocalDateTime originalDateTime = LocalDateTime.parse(originalDateTimeString);
						DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						String formattedDate = originalDateTime.format(outputFormatter);
					
					%>
						<td><%=formattedDate %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQty() %></td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getId()%>">Cancel Order</a></td>
					</tr>
				 <%}
			}
			%>
			
			</tbody>
		</table>
	</div>
</body>
</html>