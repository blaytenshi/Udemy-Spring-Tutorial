<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<title>Create a New Account</title>
</head>
<body>

	<sf:form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
	<!-- commandName finds the 'offer' object in the Model and reads from it. It needs to be a spring form to work. -->
		<table class="formtable">
			<tr>
				<td class="label">Username:</td>
				<td><sf:input class="control" name="username" type="text" path="username"/><br>
				<div class="error"><sf:errors path="username"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" name="email" type="text" path="email"/><br>
				<div class="error"><sf:errors path="email"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Password:</td>
				<td><sf:input class="control" name="password" type="text" path="password"/><br>
				<div class="error"><sf:errors path="password"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input class="control" name="confirmpass" type="text"/><br></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input class="control" value="Create Account" type="submit" /></td>
			</tr>
		</table>
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
	</sf:form>

</body>
</html>