<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Offer created.
<br>
<a href="${pageContext.request.contextPath}/offers">Click here to
	view current offers.</a>
<c:url var="homeUrl" value="/" />
<a href="${homeUrl}">Back to home</a>
