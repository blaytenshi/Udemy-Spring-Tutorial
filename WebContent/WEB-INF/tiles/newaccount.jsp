<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>Create New Account</h2>


<sf:form id="details" method="post"
	action="${pageContext.request.contextPath}/createaccount"
	commandName="user">
	<!-- commandName finds the 'offer' object in the Model and reads from it. It needs to be a spring form to work. -->
	<table class="formtable">
		<tr>
			<td class="label">Username:</td>
			<td><sf:input class="control" name="username" type="text"
					path="username" /><br>
				<div class="error">
					<sf:errors path="username"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Email:</td>
			<td><sf:input class="control" name="email" type="text"
					path="email" /><br>
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Password:</td>
			<td><sf:input class="control" id="password" name="password"
					type="password" path="password" /><br>
				<div class="error">
					<sf:errors path="password"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Confirm Password:</td>
			<td><input class="control" id="confirmpass" name="confirmpass"
				type="password" />
			<div id="matchpass"></div></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input class="control" value="Create Account" type="submit" /></td>
		</tr>
	</table>
	<input name="${_csrf.parameterName}" type="hidden"
		value="${_csrf.token}" />
</sf:form>
