<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录成功</title>
  </head>
  
  <body>
    	恭喜你，${user.username}，登录成功
    	<a href="showInfo.jsp">查看个人信息</a>
  </body>
</html>
