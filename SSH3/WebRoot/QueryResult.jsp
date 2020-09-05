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
        <table border="1" width="50%">
    	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>出发地</th>
    		<th>目的地</th>
    		<th>出发时间</th>
    		<th>身份证</th>
    	</tr>
    	<s:iterator value="books" status="stat" var="book">
    		<tr>
	    		<td><s:property value="#book.username" /></td>
	    		<td><s:property value="#book.sex" /></td>
	    		<td><s:property value="#book.origin" /></td>
	    		<td><s:property value="#book.destn" /></td>
	    		<td><s:property value="#book.date" /></td>
	    		<td><s:property value="#book.id" /></td>
    		</tr>
    	</s:iterator>
    	</table>
    </div>
  </body>
</html>
