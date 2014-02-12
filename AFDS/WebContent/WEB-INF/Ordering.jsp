<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ordering</title>
</head>
<body>
<form action = 'Ordering' method = 'post'>
<table border = '1'>
<tr><th>Item ID</th><th>Name</th><th>Price</th><th>Quantity</th></tr>
<c:forEach items="${entries}" var="entry" varStatus="status">
<tr>
				<td>${entry.productId}</td>
				<td>${entry.name}</td>
				<td>${entry.price}</td>
				<td><input id="qty" type="number" value="0"/></td></tr></td>
				</c:forEach>
				</table><br />
<input type='submit' name='order' value='Order' />
</form>
</body>
</html>