<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Review</title>
</head>
<body>
	<form action="OrderReview" method="post">
		Please review the items you ordered before placing the order. You can
		always go back to the menu to add items by clicking the
		"Back to the Menu" button.<br />
		<table border='1'>
			<tr>
				<th>Item ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${products}" var="entry" varStatus="status">
				<tr>
					<td>${entry.productId}</td>
					<td>${entry.name}</td>
					<td>${entry.price}</td>
					<td>${entry.quantity}</td>
				</tr>
			</c:forEach>
		</table>
		Total price (tax included): ${TotalPriceBeforeTax * 0.09 + TotalPriceBeforeTax}
		<br />
		<p>
			<input type="submit" name="backToTheMenu" value="Back to the Menu" />
			<input type="submit" name="placingTheOrder" value="Placing the Order" />
		</p>
	</form>
</body>
</html>