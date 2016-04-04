<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>

<c:url var="adminUrl" value="/admin"/>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<p><a href="${adminUrl}">Admin (For Admin roles only!)</a></p>
</sec:authorize>
