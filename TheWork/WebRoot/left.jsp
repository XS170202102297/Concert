<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
     <title>小麦网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  
  <body>        
        		<table width="100%" style="table-layout:fixed">	
					<tr>
						<td width="5">演出城市：</td>
						<td width="5"> <a href="mainConcert.jsp">全部</a> </td>
						<td width="5"> <a href="queryConcertByBj">北京</a> </td>
						<td width="5"> <a href="queryConcertBySh">上海</a> </td> 
						<td width="10"> <a href="queryConcertByGz">广州</a> </td>						
					</tr>
					
					<tr>
						<td width="5">歌手:</td>
						<td width="5"> <a href="mainConcert.jsp">全部</a> </td>
						<td width="5"> <a href="queryConcertByMale">男歌手</a></td>
						<td width="10"><a href="queryConcertByFemale">女歌手</a></td>
						
					</tr>
				</table> 
						
  </body>
</html>
