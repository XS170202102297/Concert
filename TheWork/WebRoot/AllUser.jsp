<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>用户信息页面</title>
    <link href="Css/css.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/js.js" charset="UTF-8">
    </script>
    
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
			<span style="width:112px;height:60px;line-height:60px;">恭喜你，管理员${custLogin.username}，登录成功</span>
			
	</div>
	<h2>所有用户信息</h2>
        <table border="1" width="50%">
    	<tr>
    		<th>姓名</th>
    		<th>性别</th>
    		<th>手机号码</th>
    		<th>年龄</th>
    		<th>密码</th>
    		<th>电子邮箱</th>
    		<th>操作</th>
    	</tr>
    	<s:iterator value="books" status="stat" var="Booking">
    		<tr>
	    		<td><s:property value="#Booking.username" /></td>
	    		<td><s:property value="#Booking.sex" /></td>
	    		<td><s:property value="#Booking.mobilePhone" /></td>
	    		<td><s:property value="#Booking.age" /></td>
	    		<td><s:property value="#Booking.password" /></td>
	    		<td><s:property value="#Booking.email" /></td>
	    		
	    		<td>
					<a href="javascript:updateTicket('<s:property value="#Booking.id2"/>')">修改</a>
					<a href="javascript:deleteTicket('<s:property value="#Booking.id2"/>')">删除</a>
				</td>
    		</tr>
    	</s:iterator>
    	</table>
    	
    [<a href="getBook?pageNo=1">首页</a>]
		<c:choose>
			<c:when test="${currentPage>1}">
				[<a href="getBook?pageNo=${currentPage-1}">上一页</a>]
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
			[<a href="getBook?pageNo=${currentPage+1}">下一页</a>]
			</c:when>
		</c:choose>
	[<a href="getBook?pageNo=${totalPage}">尾页</a>]
    </div>
  </body>
</html>
