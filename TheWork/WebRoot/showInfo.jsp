<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查看个人信息</title>
</head>

<body background="image/2.jpg"
 style="background-repeat:no-repeat; background-size:100% 100%;">
 <center>
 	
  <h1>个人信息</h1> <a href="mainConcert.jsp">&nbsp;首页</a>
  <div id="top"></div>
  <s:form action="user_updateInfo" method="post">
   <table>
    <tr>
     <td align="center"><s:textfield
       value="%{#session.user.id2}" name="id" label="ID" /></td>
    </tr>
    <tr>
     <td align="center"><s:textfield
       value="%{#session.user.username}" name="username" label="用户名" /></td>
    </tr>
     <tr>
     <td align="center"><s:textfield
       value="%{#session.user.sex}" name="sex" label="性别" /></td>
    </tr>
    <tr>
     <td align="center"><s:textfield
       value="%{#session.user.age}" name="age" label="年龄" /></td>
    </tr>
    <tr>
     <td align="center"><s:textfield
       value="%{#session.user.mobilePhone}" name="mobilePhone" label="移动电话" /></td>
    </tr>
    
    <tr></tr>
    <tr></tr>
    
   </table>
  </s:form>
 </center>
 <p align="center" ><a href="user_updateInfo.jsp">修改信息</a></p>
</body>
</html>


