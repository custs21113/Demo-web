<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<style>
body {
	background: #F1F1F1
}
</style>

<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
</head>

<a>time</a>
<a href="${APP_PATH }/loginHistory">loginHistory</a>
<body>
	<button id="login" style="border-style: none">登录</button>
	<button id="register" style="border-style: none">注册</button>
	<form action="login.do" method="get" id="login_form"
		style="display: block">
		<table>
			<tr>
				<td><input type="text" name="username" id="username"
					placeholder="username" /></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password"
					placeholder="password" /></td>
			</tr>
		</table>
		<input type="submit" value="登录" />

	</form>
	<form id="register_form" style="display: none">
		<table>
			<tr>
				<td><input type="text" name="user_name" id="user_name"
					placeholder="username" /></td>
			</tr>
			<tr>
				<td><input type="email" name="email" id="email"
					placeholder="email" /></td>
			</tr>
			<tr>
				<td><input type="text" name="cellphone" id="cellphone"
					placeholder="cellphone" /></td>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password"
					placeholder="password" /></td>
			</tr>
		</table>
		<input type="button" id="do" value="register" />
		<!-- <button type="button" id="do">注册</button> -->
	</form>
</body>
<script type="text/javascript">
	$(function() {
		//load();
		$("#register").css("color", "blue");
		$("#login").css("color", "red");
	});
	/*
	function load() {
		$("#register").css("color", "blue");
		$("#login").css("color", "red");
	};
	*/
	$("#login").click(function() {
		$("title").html("Login Page");
		$("#login_form").show();
		$("#register_form").hide();

		$("#register").css("color", "blue");
		$("#login").css("color", "red");
	});
	$("#register").click(function() {

		$("title").html("Register Page");

		$("#login_form").hide();
		$("#register_form").show();

		$("#login").css("color", "blue");
		$("#register").css("color", "red");

	});
	$("#do").click(function() {
		$.ajax({
			url : "${APP_PATH}/register.do",
			type : "POST",
			data : $("#register_form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					alert("注册成功！");
					window.location.href = "${APP_PATH}";
				} else {
					alert("注册失败！");
				}
			}
		});
	});

</script>
</html>