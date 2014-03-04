<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Menu</title>

<style>

div{
padding: 20px;
}

table,th,td
{
border:1px solid black;
border-collapse:collapse
}

th,td
{
padding:15px;
}
</style>

</head>
<body>
<div>
<img alt="menu_banner" src="images/menu_banner.jpg" width = "900" height = "113">
</div>
<!-- <h1>MENU</h1> -->
<div>
<table>
<tr bgcolor="#0f4d97">
<th><font color="#fff">Name</font></th>
<th><font color="#fff">Description</font></th>
<th><font color="#fff">Price</font></th>
<th><font color="#fff">Product Image</font></th>
<th><font color="#fff">Qty</font></th>
</tr>
<c:forEach items="${productEntries}" var="product">
<tr>
	<td>${product.name}</td>
	<td>${product.description}</td>
	<td>${product.price}</td>
	<td><img alt="${product.name }" src="${product.filePath }" width = "108" height = "72"></td>
		<td>
		<form action="Menu" method="post">
		<input type="hidden" name="productId" value="${product.productId}" /> <br />
		<input type = "submit" name ="addproduct" value = "Add to Cart">
		</form>	
		</td>
		</tr>
</c:forEach>
</table>

Items in cart: ${newOrder.orderItemTotal}
<br>

<a href = "OrderReview">Check Out</a>
</div>		

</body>
</html>