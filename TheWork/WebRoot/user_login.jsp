<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统登录</title>
  </head>
  
  <body background="image/qin.jpg"	style="background-repeat:no-repeat; background-size:100% 100%;margin-top:300px">
  <h1>
  		网上演唱会售票系统
  </h1>
    <div class="position">
   		
   		<p>
			<span style="text-align: center;color: #00ff00; ">
			<strong>
			<span style="font-size:30px; font-weight:bold;">登录</span>
			</strong>
			</span>
		</p>
   <br>
    	
	<s:form method="post" action="login_login">
		<s:textfield name="user.username" label="用户名"/>
		<s:password name="user.password" label="密码"/>
		<br>
		<s:submit value="登录"/>
	</s:form>
	<br>
	<div style="z-index:2; position:relative; margin: -55px 185px 0 0; font-size: 22px; width:100px;">
		<a href="user_register.jsp" style="text-decoration:none;">注册</a>
	</div>
	
	 </div>
  </body>
</html>
