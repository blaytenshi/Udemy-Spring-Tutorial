<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- the value of /logout is picked up by the spring filter and will clear any matching in session logins -->
<c:url var="logoutUrl" value='/logout'/>
<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>
<form action="${logoutUrl}" method="post">
	<input type="submit" value="logout"/>
	<!-- required by spring because it has implemented csrf protection -->
	<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
</form>
</body>
</html>