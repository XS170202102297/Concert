<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>密码修改</title>
		 <link href="Css/css.css" rel="stylesheet" type="text/css">
	</head>
	<body>
 	 <div align="center">
  		 <div class="title">
  	 		<div class="photo">
 	 			<img src="image/logo.jpg" alt="携程旅行" width="200" height="100"> 	
  	 		</div>	 
  		 </div>
  	 
	 	<div class="header" >
			<div class='logo'>导航栏</div>
			<ul>
				<li class="first"><a href="Booking.jsp">首页</a></li>
				<li ><a href="ChangePassword.jsp">修改密码</a></li>
				<li ><a href="exitAction">退出系统</a></li>
				<li ><a href="QueryTicketByCriteria.jsp">条件查询信息</a></li>
			</ul>
			
		</div>
		<div class="body">
			<h2>修改密码</h2>
			<s:form action="changePasswordAction" method="post">
				  用户名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${custLogin.username}
				<s:password name="oldPassword" size="20" label="旧密码"/>
				<s:password name="newPassword" size="20" label="新密码"/>
				<s:password name="newPassword2" size="20" label="确认新密码"/>
				<s:submit value="确认"/>
			</s:form>
		</div>
	</div>
	</body>
</html>
