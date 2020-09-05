<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>小麦网</title>
    <link href="Css/css.css" rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	 
		<table width="100%" style=" table-layout:fixed " >
			<tr>						
				<td width="100"><a href="mainConcert.jsp"><img src="Images/icons/concert.jpg" width="30" height="30">&nbsp;首页</a></td>
				<!-- 搜索单个演唱会  -->
				
				<td width="500">
					<s:form action="queryConcertByCriteria"  method="post" >	
	  					<s:textfield name="concert.ticketName" theme = "simple" 
	  						 cssStyle="border-radius: 10px;  border: 1px solid grey;  size:10px; width:200px; height:30px"/>
	    				
	    				<s:submit value="搜索" theme = "simple"
	    				 cssStyle="border-radius: 10px;  border: 1px solid grey;  size:10px; width:50px; height:30px" />
	  	   			 </s:form></td>
	  	   		
	  	   		
	  	   		<td width="30"><img src="Images/icons/search.jpg" width="30" height="30"></td>
				<td width="100"><a href="MyOrder.jsp">我的订单</a></td>
			
				
					<c:choose>
						<c:when test="${user == null }">
							<td width="50"><img src="Images/icons/login.jpg" width="30" height="30"></td>
							<td width="50"><a href="user_register.jsp">注册</a></td>
							<td width="100"><a href="user_login.jsp">登录</a></td>
						</c:when>
						<c:otherwise>
							<td width="300">欢迎您，<a>${user.username }</a> [<a href="userExitAction?exit=true">退出登录</a>][<a href="user_updateInfo.jsp">修改资料</a>] [<a href="user_changepwd.jsp">更改密码</a>]</td>
						</c:otherwise>
						</c:choose>
				
			</tr>		
		</table>
  </body>
</html>
