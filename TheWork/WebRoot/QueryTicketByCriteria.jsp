<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>条件查询信息</title>
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
			<span style="width:112px;height:60px;line-height:60px;"></span>
			
		</div>
		<div class="body">
	   		<h2 align="center">查询用户信息</h2>
 		 	<s:form action="queryTicketByCriteriaAction"  method="post" >
	  		<s:textfield name="book.username" label="用户名"/>
	    	<s:submit value="确认查询" />
	  	    </s:form>
	    </div>
    </div>
  </body>
</html>
