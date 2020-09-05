<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>添加演唱会</title>
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
    <div class="content" align="center">
    	<h1>添加演唱会</h1>
    	<s:form method="post" action="addTicketAction">
    		<s:textfield name="ticket.ticketName" label="演唱会名称" ></s:textfield>
    		<s:textfield name="ticket.singer" label="歌手"></s:textfield>
    		<s:textfield name="ticket.kind" label="类型"></s:textfield>
    		<s:textfield name="ticket.day" label="日期"></s:textfield>
    		<s:textfield name="ticket.time" label="时间"></s:textfield>
    		<s:textfield name="ticket.place" label="场地"></s:textfield>
    		<s:textfield name="ticket.price" label="最低价格"></s:textfield>
    		<s:submit value="添加"/>
    	</s:form>
    </div>
    </div>
    <div class="pg_footer"></div>
  </body>
</html>
