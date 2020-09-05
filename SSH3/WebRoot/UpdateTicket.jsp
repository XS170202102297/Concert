<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>修改订票信息页面</title>
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
    <h2 align="center">修改订票信息</h2>
 	 <s:form action="updateTicketAction"  method="post" >
 		 <s:hidden name="book.id2"/>
	    <s:textfield name="book.username" label="用户名"/>
	    <s:radio name="book.sex" list="%{#{'男':'男','女':'女'}}" label="性别"/>
	    <s:textfield name="book.origin" label="始发城市"/>
	    <s:textfield name="book.destn" label="目的城市"/>
	    <s:textfield name="book.date" label="出发日期"/>
	    <s:textfield name="book.id" label="身份证"/>
	    
	    <s:submit value="确定修改" />
	</s:form>
	</div>
  </div>
  </body>
</html>
