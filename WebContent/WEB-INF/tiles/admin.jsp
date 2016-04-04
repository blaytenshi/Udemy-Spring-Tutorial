<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="homeUrl" value="/" />
<h3>Authorized users only</h3>

<table class="formtable">
	<tr>
		<td>User name</td>
		<td>Email</td>
		<td>Role</td>
		<td>Enabled</td>
	</tr>
	<!-- The ${users} is the variable passed back from the Login Controller's model when we called the "/admin" mapping -->
	<c:forEach items="${users}" var="user">
		<tr>
			<td><c:out value="${user.username}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.authority}" /></td>
			<td><c:out value="${user.enabled}" /></td>
		</tr>
	</c:forEach>
</table>

<a href="${homeUrl}">Back to home</a>
