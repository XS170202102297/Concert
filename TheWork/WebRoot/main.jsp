<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  	
   	<title>小麦网</title>
 
   	<link href="Css/css.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/js.js" charset="UTF-8"></script>
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
	  	   		
	  	     			
    			<div class="head3" >	<!-- 分类  -->	
    				<jsp:include page="left.jsp"></jsp:include>  		
    			</div>
    			
    			<div class="head4"  >	<!-- 排序  -->			
    						<a href="queryConcertOrderByPrice">价格升序</a>&nbsp;&nbsp;&nbsp;&nbsp;
    						<a href="queryConcertOrderByTime">最近开场</a>		
    			</div>
    			
    		</div>
    		
			<div class="scroll" > <!-- 轮播图  在ScrollImg.jsp页面 -->	
	  			 <jsp:include page="ScrollImg.jsp"></jsp:include>  	
			</div>


			<!-- 演唱会内容展示  -->
    		<div class="main" >	
    										    			    							
    					<s:iterator value="concerts" status="stat" var="concert">
    							<hr align="center" width="600px"/>
    					<table width="100%" style=" table-layout:fixed ">
    					  
    						<tr>
    							<td width="200"></td>
    							<td width="500"></td>
    							<td width="200"><div class="photo" >
    								<br/><br/><br/><br/>
    								<img src='Images/smallImages/<s:property value="#concert.ticketid"/>.jpg' alt='<s:property value="concert.ticketName"/>' width="155" height="180" />
    								
    								</div>
    							</td>
    							<td width="200"><div class="word">
	    							名字：<s:property value="#concert.ticketName" /><br/>
									歌手：<s:property value="#concert.singer" /><br/>
									价格：<s:property value="#concert.price"/>起<br/>
									分类：<s:property value="#concert.kind" /><br/>
									日期：<s:property value="#concert.day" /><br/>
									时间：<s:property value="#concert.time" /><br/>
									地点：<s:property value="#concert.place" /><br/>
	    							</div>
	    						</td>
	    						<td>
	    							<!-- 购买 -->
	    							<a href="javascript:buy('<s:property value="#concert.ticketid"/>')"><img src="Images/icons/buy.jpg" width="30" height="30"></a>
	    						</td>
	    					</tr>
	   			 		</table>  		
    				</s:iterator>
    			
    			
    			
    				
    					<!-- 分页操作  -->
    	  				  [<a href="getConcertAction?pageNo=1">首页</a>]
							<c:choose>
								<c:when test="${currentPage>1}">
								<a href="getConcertAction?pageNo=${currentPage-1}"><img src="Images/icons/left.jpg" width="30" height="20"></a>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${currentPage<totalPage}">
								<a href="getConcertAction?pageNo=${currentPage+1}"><img src="Images/icons/right.jpg" width="30" height="20"></a>
								</c:when>
							</c:choose>
								[<a href="getConcertAction?pageNo=${totalPage}">尾页</a>]
				
	    		   			
   		</div><!-- main块  -->
  </div>
  </body>
</html>
