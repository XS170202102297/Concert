<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body background="Images/Sea.jpg"	style="background-repeat:no-repeat; background-size:100% 100%">
  <div id="all" align="center">
  	 		<div class="head" >		<!-- 导航栏  -->
  	 			<div class="head1" align="left">
  	 				<table width="50%" style=" table-layout:fixed"><tr>
  	 					<td width="500"></td>
  	 					<td><img src="Images/smallImages/logo.jpg" alt="小麦购票" width="100" height="100"> </td>
	   			 		<td><jsp:include page="head.jsp"></jsp:include></td>
	  	   			 </tr></table>
	  	   		 </div>
	  	   </div>
    <h2>确认订单</h2>
    
     <div  align="center">
		<s:form action="updatePriceAction"  method="post" theme="simple">
			用户名称：<s:text name="user.username"></s:text><br>
			<s:hidden name="user.id2"></s:hidden>
			<s:hidden name="concert.ticketid"/>
			<s:hidden name="concert.price"/>
			演唱会：<s:text name="concert.ticketName" /><br>
			歌手：<s:text name="concert.singer" /><br>
			类型：<s:text name="concert.kind" /><br>
			日期：<s:text name="concert.day" /><br>
		   	 时间：<s:text name="concert.time" /><br>
			地点：<s:text name="concert.place" /><br>
			选择座位：<br>
			第<s:textfield name="ms.row" />排
			第<s:textfield name="ms.col" />座
			<s:submit value="获取价格"/>
		</s:form>
		<h3>剩余座位</h3>
		<s:form >
		<table  border="1" >
		<tr align="center" >
		<s:iterator value="set" status="stat" var="seat">
			
				<td><s:property value="#seat.row"/><s:property value="#seat.col"/></td>
				<s:if test="#seat.row=='2排'&&#seat.col=='1座'">
				</tr><tr>
				</s:if>
				<s:elseif test="#seat.row=='3排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='4排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='5排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='6排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='7排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='8排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='9排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				<s:elseif test="#seat.row=='10排'&&#seat.col=='1座'">
				</tr><tr>
				</s:elseif>
				
		</s:iterator>
		</tr>
		
		</table>
		 
		</s:form>
		</div>
	  	   </div>
     
  </body>
</html>
