<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>系统注册</title>
	</head>
	<body>
	<body background="image/qin.jpg"	style="background-repeat:no-repeat; background-size:100% 100%;margin-top:300px">
	<h1>
  		网上演唱会售票系统
  </h1>
		<h2>用户注册</h2>
		<s:form action="login_register"  method="post" >
		<s:textfield name="user.username" label="姓名"/>
		<s:password name="user.password" size="20" label="密码"/>
		<s:password name="rePassword" size="20" label="确认密码"/>
		<s:textfield name="user.sex" label="性别"/>
	    <s:textfield name="user.age" label="年龄" />
		<s:textfield name="user.email" label="电邮" />
		<s:textfield name="user.mobilePhone" label="电话" />
		<s:submit value="注册"/>
		</s:form>
	</body>
</html>

