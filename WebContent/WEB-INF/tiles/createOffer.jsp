<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<sf:form method="post"
	action="${pageContext.request.contextPath}/doCreate"
	commandName="offer">
	<!-- commandName finds the 'offer' object in the Model and reads from it. It needs to be a spring form to work. -->
	<table class="formtable">
		<tr>
			<td class="label">Name:</td>
			<td><sf:input class="control" name="name" type="text"
					path="name" /><br>
			<sf:errors path="name" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><sf:input class="control" name="email" type="text"
					path="email" /><br>
			<sf:errors path="email" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label">Your Offer:</td>
			<td><sf:textarea class="control" name="text" rows="10" cols="10"
					path="text"></sf:textarea><br>
			<sf:errors path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input class="control" value="Create Advert" type="submit" /></td>
		</tr>
	</table>
</sf:form>

<c:url var="homeUrl" value="/" />
<a href="${homeUrl}">Back to home</a>

