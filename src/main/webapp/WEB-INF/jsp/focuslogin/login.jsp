<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
  	<%@ include file="../layout/htmlHeader.jsp"%>
    <title>Focus管理后台</title>
   	<link rel="stylesheet" href="<%=path%>/css/focuslogin/login.css?t=20151206000"/>
  </head>
  <body>
  	<div class="focus-login">
  	  <div class="focus-login-title">Focus后台管理</div>
  	  <div class="focus-login-form">
		  <form id="loginForm" action="<%=path%>/focuslogin/loginCheck.htm" method="post">
		  	<input type="hidden" name="notifyUrl" value="${notifyUrl}" />
		  	<div class="focus-login-username">
		  		<input id="userNameId" class="input" type="text" placeholder="输入账号" name="username" />
		  	</div>
		  	<div class="focus-login-password">
		  		<input id="passwordId" class="input" type="password" placeholder="输入密码" name="password" />
		  	</div>
		  	<div class="focus-login-error-msg">${error_msg}</div>
			<div class="blue-btn login-btn" onclick="clickSubmit();">登录</div>
		  </form>
	  </div>
	</div>
  </body>
<script src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=path%>/js/focuslogin/login.js?t=20151206000"></script>
</html>