<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'QueryResult.jsp' starting page</title>
    
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
				<li class="first"><a href="Booking.jsp">首页</a></li>
				<li ><a href="ChangePassword.jsp">修改密码</a></li>
				<li ><a href="RegLogin.jsp">退出系统</a></li>
				<li ><a href="QueryTicketByCriteria.jsp">条件查询</a></li>
				<li ><a href="Booking.jsp">添加新用户</a></li>
			</ul>		
	</div>
        <table border="1" width="50%">
    	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>手机号码</th>
    		<th>年龄</th>
    		<th>密码</th>
    		<th>邮箱</th>
    	</tr>
    	<s:iterator value="books" status="stat" var="book">
    		<tr>
	    		<td><s:property value="#book.username" /></td>
	    		<td><s:property value="#book.sex" /></td>
	    		<td><s:property value="#book.mobilePhone" /></td>
	    		<td><s:property value="#book.age" /></td>
	    		<td><s:property value="#book.password" /></td>
	    		<td><s:property value="#book.email" /></td>
    		</tr>
    	</s:iterator>
    	</table>
    </div>
  </body>
</html>
