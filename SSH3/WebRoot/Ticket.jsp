<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>机票预定信息</title>
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
  	<h1>您的机票预定信息</h1>
    <table border="1" width="50%">
  	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>出发地</th>
    		<th>目的地</th>
    		<th>出发时间</th>
    		<th>身份证</th>
    </tr>
    
	<tr>
		<td><s:property value="#session.booking.username"/></td>
		<td><s:property value="#session.booking.sex"/></td>
		<td><s:property value="#session.booking.origin"/></td>
		<td><s:property value="#session.booking.destn"/></td>
		<td><s:property value="#session.booking.date"/></td>
		<td><s:property value="#session.booking.id"/></td>
	</tr>
	
	</table>
	 <s:form method="post" action="getBook" >
	 
	  <s:submit value="查看所有信息" />
	</s:form>
	</div>

  </body>
</html>
