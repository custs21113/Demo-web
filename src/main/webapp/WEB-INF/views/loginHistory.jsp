<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login History</title>
</head>
<body>
HISTROY="${requestScope.user_id }";
	 <table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>login_id</th>
			<th>user_id</th>
			<th>login_time</th>
			<th>login_ip</th>
			<th colspan="2">Operate</th>
		</tr>
		<c:forEach items="${requestScope.userLoginLogs }" var="userLoginLog">
		<tr>
		<td>${userLoginLog.login_id }</td>
		<td>${userLoginLog.user_id }</td>
		<td>${userLoginLog.login_time }</td>
		<td>${userLoginLog.login_ip }</td>
		<td><a href="#">Edit</a></td>
		<td><a href="#">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>