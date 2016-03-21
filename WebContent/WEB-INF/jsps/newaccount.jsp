<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.12.1.min.js"></script>

<script type="text/javascript">

	function onLoad() {
		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);
		
		$("#details").submit(canSubmit);
	}
	
	function canSubmit() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		
		if (password != confirmpass) {
			alert("<fmt:message key='UnmatchedPasswords.user.password' />")
			return false;
		} else {
			return true;
		}
	}
	
	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		
		if (password.length > 3 || confirmpass.length > 3) {
			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}

	$(document).ready(onLoad);

</script>
<title>Create a New Account</title>
</head>
<body>
	<h2>Create New Account</h2>
	
	
	<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
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
				<td><sf:input class="control" id="password" name="password" type="password" path="password"/><br>
				<div class="error"><sf:errors path="password"></sf:errors></div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password:</td>
				<td><input class="control" id="confirmpass" name="confirmpass" type="password"/><div id="matchpass"></div></td>
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