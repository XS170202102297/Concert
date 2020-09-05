<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title></title>
    <link href="Css/css.css" rel="stylesheet" type="text/css">

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
     <div class="" align="center">
     <h2>确认订单</h2>
		<s:form action="addOrderAction"  method="post" theme="simple">
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
			<s:hidden name="st.sid"/>
			座位：<s:text name="st.row" /><s:text name="st.col" /><br>
			价格：<s:text name="st.price"></s:text><br>
			<s:submit value="确认购买"/>
		</s:form>
    </div>
    </div>
  </body>
</html>
