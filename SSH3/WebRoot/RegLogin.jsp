<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册/登录</title>
  	 
  </head>
  
  <body>
  <div align="center">
  	<h2>用户登录</h2>
 	<s:property value="errorMessage" />
	<s:form method="post" action="loginAction">
	    <s:textfield name="custLogin.username" label="用户名"/>
	    <s:password name="custLogin.password" label="登陆密码"/>
	    <s:submit name="lsubmit" value="登录" />
	</s:form>

	<hr align="left" width="60%" color="RED"/>
	<h2>用户注册</h2>
	 <s:form method="post" action="registerAction" >
	    <s:textfield name="custRegister.username" label="用户名"/>
	    <s:password name="custRegister.password" label="密码"/>
	    <s:password name="custRegister.password2" label="确认密码"/>
	    <s:submit name="rsubmit" value="注册" />
	</s:form>
    </div>
  </body>
</html>
