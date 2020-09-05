<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>修改用户信息页面</title>
     <link href="Css/css.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>
  <div align="center">
  	 <div class="title">
  	 	
  	 </div>
  	 
	 <div class="header" >
		<div class='logo'>演唱会系统导航栏</div>
			<ul>
				<li class="first"><a href="AllUser.jsp">管理用户</a></li>
				<li ><a href="ChangePassword.jsp">修改密码</a></li>
				<li ><a href="RegLogin.jsp">退出系统</a></li>
				<li ><a href="QueryTicketByCriteria.jsp">条件查询</a></li>
			<li ><a href="Booking.jsp">添加新用户</a></li>
			<li ><a href="Management.jsp">返回首页</a></li>
			</ul>
	</div>
	<div class="body">
    <h2 align="center">修改用户信息</h2>
 	 <s:form action="updateTicketAction"  method="post" >
 		 <s:hidden name="book.id2"/>
	    <s:textfield name="book.username" label="用户名"/>
	    <s:radio name="book.sex" list="%{#{'男':'男','女':'女'}}" label="性别"/>
	    <s:textfield name="book.mobilePhone" label="手机号码"/>
	    <s:textfield name="book.age" label="年龄"/>
	    <s:textfield name="book.password" label="密码"/>
	    <s:textfield name="book.email" label="电子邮箱"/>
	    
	    <s:submit value="确定修改" />
	</s:form>
	</div>
  </div>
  </body>
</html>
