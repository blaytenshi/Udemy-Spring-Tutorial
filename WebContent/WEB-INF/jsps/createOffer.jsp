<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<sf:form method="post" action="${pageContext.request.contextPath}/doCreate" commandName="offer">
	<!-- commandName finds the 'offer' object in the Model and reads from it.  -->
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" name="name" type="text" path="name"/></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td><sf:input class="control" name="email" type="text" path="email"/></td>
			</tr>
			<tr>
				<td class="label">Your Offer:</td>
				<td><sf:textarea class="control" name="text" rows="10" cols="10" path="text"></sf:textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input class="control" name="Create Advert" type="submit" /></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>