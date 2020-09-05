<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>演唱会信息</title>
     <script type="text/javascript" src="js/js.js" charset="UTF-8">
    </script>
	<style>
    body{
        margin: 0 auto;
    }
    .pg_header{
        height: 48px;
        background-color: #2459a2;
        color: white;
    }
    .pg_content .menu{
            position: fixed;
            top: 50px;
            left: 0;
            bottom: 0;
            width: 200px;
            background-color: #dddddd;
     }
    .pg_content .content{
            position: fixed;
            top: 50px;
            right: 0;
            bottom: 0;
            left: 202px;
            
            overflow: auto;
     }
     .Manmenu a{
     	text-decoration : none
     }
 
</style>
  </head>
  
  <body>
  <div class="pg_header"></div>
    <div class="pg_content">
    <div class="menu">
    	<ul class="Manmenu">
    		<li><a href="AddCon.jsp">添加演唱会</a></li>
    		<li><a href="Success.jsp">演唱会管理</a></li>
    		<li><a href="AllUser.jsp">用户信息管理</a></li>
    	</ul>
    </div>
    <div class="content">
    	<s:form method="post" action="queryAction">
  		<s:submit value="显示所有演唱会" />
  	</s:form>
  <div align="center">
  	<h2>演唱会信息</h2>
    	<table border="1" width="60%"  border="0" cellpadding="3" cellspacing="1" bgcolor="#99FFFF" style="margin-bottom:8px;margin-top:8px;">
		<tr>
			<th>演唱会</th>
			<th>歌手</th>
			<th>类型</th>
			<th>日期</th>
			<th>时间</th>
			<th>场地</th>
			<th>最低价格</th>
			<th>操作</th>
			
		</tr>
		<s:iterator value="tk" status="st" var="ticket">
			<tr align="center" >
				<td><s:property value="#ticket.ticketName"/></td>
				<td><s:property value="#ticket.singer"/></td>
				<td><s:property value="#ticket.kind"/></td>
				<td><s:property value="#ticket.day"/></td>
				<td><s:property value="#ticket.time"/></td>
				<td><s:property value="#ticket.place"/></td>
				<td><s:property value="#ticket.price"/></td>
				<td>
					<a href="javascript:queryTicketDetails('<s:property value="#ticket.ticketid"/>')">座位信息</a>
					<a href="javascript:queryTicket('<s:property value="#ticket.ticketid"/>')">修改</a>
					<a href="javascript:deleteCon('<s:property value="#ticket.ticketid"/>')">删除</a>
					
				</td>
			</tr>
		</s:iterator>
	</table>
	</div>
	[<a href="queryAction?pageNo=1">首页</a>]
		<c:choose>
			<c:when test="${currentPage>1}">
				[<a href="queryAction?pageNo=${currentPage-1}">上一页</a>]
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
			[<a href="queryAction?pageNo=${currentPage+1}">下一页</a>]
			</c:when>
		</c:choose>
	[<a href="queryAction?pageNo=${totalPage}">尾页</a>]
    </div>
    </div>
    <div class="pg_footer"></div>
  
   
  </body>
</html>
