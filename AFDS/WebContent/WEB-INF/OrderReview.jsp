<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Review</title>

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
	<form action="OrderReview" method="post">
		Please review the items you ordered before placing the order. You can
		always go back to the menu to add or delete items by clicking the
		"Back to the Menu" button.<br />
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Qty</th>
				<th>Unit Price</th>
				<th>Price</th>

			</tr>
			<c:forEach items="${newOrder.orderItemList}" var="orderItem"
				varStatus="count">
				<tr>
					<td>${orderItem.item.name}</td>
					<td>${orderItem.item.description}</td>
					<td><input type="number" value="${orderItem.itemQuantity}"
						name="order${count.index}"></td>
					<td><fmt:formatNumber value="${orderItem.item.price}"
							type="currency" /></td>
					<td><fmt:formatNumber
							value="${orderItem.item.price * orderItem.itemQuantity}"
							type="currency" /></td>
					<td>
					<td><a href="ModifyOrder?itemNo=${count.index}&op=remove">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		Total price (tax included):
		<fmt:formatNumber
			value="${(newOrder.orderTotal * 0.09) + newOrder.orderTotal}"
			type="currency" />
		<br />
		<p>
			<input type="submit" name="backToTheMenu" value="Back to the Menu" />
			<input type="submit" name="placingTheOrder" value="Place Order" /> <input
				type="submit" name="updateTotal" value="Update Total" />
		</p>
	</form>
</body>
</html>