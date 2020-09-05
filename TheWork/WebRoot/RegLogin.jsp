<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册/登录</title>
  	 
  </head>
  
  <body background="image/1111.jpg" style="background-repeat:no-repeat; background-size:100% 100%">
  <div align="center">
  	<h2>管理员登录</h2>
 	<s:property value="errorMessage" />
	<s:form method="post" action="loginAction">
	    <s:textfield name="custLogin.username" label="用户名"/>
	    <s:password name="custLogin.password" label="登陆密码"/>
	    <s:submit name="lsubmit" value="登录" />
	</s:form>
	</div>
	<div style="z-index:2; position:relative; left:900px; margin: -50px -55px 11 0; font-size: 22px; width:100px;">
	<a href="A-Reg.jsp" >注册</a>
    </div>
  </body>
</html>
