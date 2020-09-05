<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>我的订单</title>
    
	
	<script type="text/javascript" src="js/js.js" charset="UTF-8">
    </script>

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
   <s:form method="post" action="queryOrderAction">
  		<s:submit value="显示所有订单" />
  	</s:form>
  	<table border="1" width="90%">
     <tr>
    		<th>演唱会</th>
    		<th>座位</th>
    		<th>操作</th>
    		
    	</tr>
    	<s:iterator value="ord" status="st" var="order">
			<tr align="center" >
				<td><s:property value="#order.ticketName"/></td>
				<td><s:property value="#order.seat"/></td>
			
				<td>
					<a href="javascript:queryOrderDetial('<s:property value="#order.id"/>')">详细信息</a>
					
					
				</td>
			</tr>
		</s:iterator>
	
    </table>
    [<a href="queryOrderAction?pageNo=1">首页</a>]
		<c:choose>
			<c:when test="${currentPage>1}">
				[<a href="queryOrderAction?pageNo=${currentPage-1}">上一页</a>]
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
			[<a href="queryOrderAction?pageNo=${currentPage+1}">下一页</a>]
			</c:when>
		</c:choose>
	[<a href="queryOrderAction?pageNo=${totalPage}">尾页</a>]
    </div>
	  	   </div>
  </body>
</html>
