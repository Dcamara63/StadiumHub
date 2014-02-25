<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User Registration</title>
</head>
<body>
	<form action="UserRegistration" method="post">
		<table border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td>Username:</td>
					<td><input name="username" type="text" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input name="password" type="password" /></td>
				</tr>
				<tr>
					<td valign="top">Re-type password:</td>
					<td><input name="retypePassword" type="password" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input name="firstName" type="text" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input name="lastName" type="text" /></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input name="age" type="text" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>M<input type="radio" name="gender" value="m" /> F<input
						type="radio" name="gender" value="f" /><br /></td>
				</tr>
				<tr>
					<td><b>Credit Card Information</b></td>
				</tr>
				<tr>
					<td>Credit Card Number:</td>
					<td><input name="creditCardNo" type="text" /></td>
				</tr>
				<tr>
					<td>Expiration Time (MM/dd/yyyy):</td>
					<td><input name="expirationTime" type="text" /></td>
				</tr>
				<tr>
					<td>Security Code (A 3 Digit Code Located on the Back of Your
						Credit Card):</td>
					<td><input name="securityCode" type="text" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input name="address" type="text" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input name="city" type="text" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input name="state" type="text" /></td>
				</tr>
				<tr>
					<td>Zipcode:</td>
					<td><input name="zipcode" type="text" /></td>
				</tr>
				<tr>
					<td><b>Seating Information</b></td>
				</tr>
				<tr>
					<td>Section Number:</td>
					<td><input name="sectionNo" type="text" /></td>
				</tr>
				<tr>
					<td>Row Number:</td>
					<td><input name="rowNo" type="text" /></td>
				</tr>
				<tr>
					<td>Seat Number:</td>
					<td><input name="seatNo" type="text" /></td>
				</tr>
			</tbody>
		</table>
		<p>
			<input name="register" type="submit" value="Register" />
		</p>
		<c:if test="${not empty usernameLengthError}">
		${usernameLengthError}<br />
		</c:if>
		<c:if test="${not empty usernameEmptyError}">
		${usernameEmptyError}<br />
		</c:if>
		<c:if test="${not empty passowrdLengthError}">
		${passowrdLengthError}<br />
		</c:if>
		<c:if test="${not empty passowrdEmptyError}">
		${passowrdEmptyError}<br />
		</c:if>
		<c:if test="${not empty retypePassowrdDoesNotMatchError}">
		${passowrdEmptyError}<br />
		</c:if>
		<c:if test="${not empty retypePassowrdDoesNotMatchError}">
		${creditCardLengthError}<br />
		</c:if>
		<c:if test="${not empty firstNameEmptyError}">
		${firstNameEmptyError}<br />
		</c:if>
		<c:if test="${not empty lastNameEmptyError}">
		${lastNameEmptyError}<br />
		</c:if>
		<c:if test="${ageEmptyError}">
		${ageEmptyError}<br />
		</c:if>
		<c:if test="${not empty creditCardLengthError}">
		${creditCardLengthError}<br />
		</c:if>
		<c:if test="${not empty creditCardNoEmptyError}">
		${creditCardNoEmptyError}<br />
		</c:if>
		<c:if test="${not empty expirationTimeEmptyError}">
		${expirationTimeEmptyError}<br />
		</c:if>
		<c:if test="${not empty securityCodeEmptyError}">
		${securityCodeEmptyError}<br />
		</c:if>
		<c:if test="${not empty addressEmptyError}">
		${addressEmptyError}<br />
		</c:if>
		<c:if test="${not empty cityEmptyError}">
		${cityEmptyError}<br />
		</c:if>
		<c:if test="${not empty stateEmptyError}">
		${stateEmptyError}<br />
		</c:if>
		<c:if test="${not empty zipcodeLengthError}">
		${zipcodeLengthError}<br />
		</c:if>
		<c:if test="${not empty zipcodeEmptyError}">
		${zipcodeEmptyError}<br />
		</c:if>
		<c:if test="${not empty sectionNoEmptyError}">
		${sectionNoEmptyError}<br />
		</c:if>
		<c:if test="${not empty rowNoEmptyError}">
		${rowNoEmptyError}<br />
		</c:if>
		<c:if test="${not empty seatNoEmptyError}">
		${seatNoEmptyError}<br />
		</c:if>
		<c:if test="${not empty usernameExistsError}">
		${usernameExistsError}<br />
		</c:if>
	</form>
</body>
</html>