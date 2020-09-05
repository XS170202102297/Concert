<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>订单处理页面</title>
    <script type="text/javascript" src="js/js.js" charset="UTF-8">
    </script>
    
    
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
     <div class="" align="center">		 
     <table border="1" width="90%">
     <tr>
    		<th>用户名</th>
    		<th>演唱会</th>
    		<th>歌手</th>
    		<th>日期</th>
    		<th>时间</th>
    		<th>地点</th>
    		<th>座位</th>
    		<th>价格</th>
    		<th>操作</th>
    		
    	</tr>
    	<tr>
    	<td><s:text name="user.username"></s:text></td>
	    <td><s:text name="concert.ticketName"></s:text></td>
	   <td><s:text name="concert.singer"></s:text></td>
	    <td><s:text name="concert.day"></s:text></td>
	    <td><s:text name="concert.time"></s:text></td>
	    <td><s:text name="concert.place"></s:text></td>
	    <td><s:text name="seat.row"></s:text><s:text name="seat.col"></s:text></td>
	    
	    <td><s:text name="seat.price"></s:text></td>
		
		<td>
		<a href="javascript:deleteod('<s:property value="seat.sid"/>')">退票</a>
		</td>		
	</tr>
	
    </table>
    
    </div>
</div>	    

  </body>
</html>
