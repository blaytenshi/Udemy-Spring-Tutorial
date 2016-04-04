<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a class="title" href="<c:url value='/'/>">Offers</a>
<!-- the value of /logout is picked up by the spring filter and will clear any matching in session logins -->
<c:url var="logoutUrl" value='/logout'/>

<c:url var="loginUrl" value="/login"/>
<!-- Yes you can use boolean for the expressions -->
<sec:authorize access="!isAuthenticated()">
	<a class="login" href="${loginUrl}">Login</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<form action="${logoutUrl}" method="post">
	<input class="login" type="submit" value="logout"/>
	<!-- required by spring because it has implemented csrf protection -->
	<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
</form>
</sec:authorize>