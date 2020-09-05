<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册/登录</title>
  	 
  </head>
  
 <body background="image/1111.jpg" style="background-repeat:no-repeat; background-size:100% 100%">
  <div align="center">
  	

	<h2>管理员注册</h2>
	 <s:form method="post" action="registerAction" >
	    <s:textfield name="custRegister.username" label="用户名"/>
	    <s:password name="custRegister.password" label="密码"/>
	    <s:password name="custRegister.password2" label="确认密码"/>
	    <s:submit name="rsubmit" value="注册" />
	</s:form>
    </div>
  </body>
</html>
