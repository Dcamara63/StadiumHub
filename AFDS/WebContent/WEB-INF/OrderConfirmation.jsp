<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thanks for Your Order</title>
<style>
table,th,td {
	border: 1px solid black;
	border-collapse: collapse
}

th,td {
	padding: 15px;
}
</style>


</head>
<body>

<h1>Thanks for your order!</h1>
			<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Qty</th>
				<th>Unit Price</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${orderList[param.orderId].orderItemList}" var="orderItem"
				varStatus="count">
				<tr>
					<td>${orderItem.item.name}</td>
					<td>${orderItem.item.description}</td>
					<td>${orderItem.itemQuantity}</td>
					<td><fmt:formatNumber value="${orderItem.item.price}"
							type="currency" /></td>
					<td><fmt:formatNumber
							value="${orderItem.item.price * orderItem.itemQuantity}"
							type="currency" /></td>
					<td>
				</tr>
			</c:forEach>
		</table>
		Total price (tax included):
		<fmt:formatNumber
			value="${(newOrder.orderTotal * 0.09) + newOrder.orderTotal}"
			type="currency" />
		<br />




	<form action="OrderConfirmation" method="post">
		Thanks you for choosing our food stand as your dining choice.
		Your order has been sent to the nearest kitchen. Food will arrive shortly.
		Enjoy!<br /> <input type="submit" name="exit" value="Exit" />
		<c:remove var="user" scope="session" />
	</form>
</body>
</html>