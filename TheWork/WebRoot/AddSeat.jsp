<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>座位信息</title>
  </head>
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
     	text-decoration : none;
     }
 	.content p{
 		font-weight: bold;
 	}
</style>
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
    	<h2 >座位信息操作</h2>
    	<p>设置全部</p>
		<s:form action="addSeatAction"  method="post" theme="simple">
			
			<s:hidden name="ticket.ticketid"/>
			设置<s:textfield name="ms.row" label="" cssStyle="width:30px;height:20px"/>排 
			<s:textfield name="ms.col" label="" cssStyle="width:30px;height:20px"/>座
			价格：<s:textfield name="seat.price" cssStyle="width:60px;height:20px"/>
			<s:submit value="设置座位"/>
		</s:form>
		<p>新增座位</p>
		<s:form action="aSeatAction"  method="post" theme="simple">
			<s:hidden name="ticket.ticketid"/>
			第<s:textfield name="ms.row" label=""  cssStyle="width:30px;height:20px"/>排 
			添加<s:textfield name="ms.col" label="" cssStyle="width:30px;height:20px"/>座
			价格：<s:textfield name="seat.price" cssStyle="width:60px;height:20px"/>
			<s:submit value="添加座位"/>
		</s:form>
		
		<p>修改价格</p>
		<s:form action="updateSeatAction"  method="post" theme="simple">
			<s:hidden name="ticket.ticketid"/>
			第<s:textfield name="seat.row" label=""  cssStyle="width:30px;height:20px"/>排 
			第<s:textfield name="seat.col" label="" cssStyle="width:30px;height:20px"/>座
			价格修改为：<s:textfield name="seat.price" cssStyle="width:60px;height:20px" />
			<s:submit value="修改价格"/>
		</s:form>
		<p>删除座位</p>
		<s:form action="deleteSeatAction"  method="post" theme="simple">
			<s:hidden name="ticket.ticketid"/>
			删除第<s:textfield name="seat.row" label="" cssStyle="width:30px;height:20px"/>排 
			第<s:textfield name="seat.col" label="" cssStyle="width:30px;height:20px"/>座
			<s:submit value="删除座位"/>
		</s:form>
    </div>
    </div>
    <div class="pg_footer"></div>
  </body>
</html>
