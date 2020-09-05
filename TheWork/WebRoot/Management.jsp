<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>后台管理</title>
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
    <div class="content"></div>
    </div>
    <div class="pg_footer"></div>
  </body>
</html>
