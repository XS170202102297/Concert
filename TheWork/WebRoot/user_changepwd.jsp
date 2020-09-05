<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body background="Images/Sea.jpg"	style="background-repeat:no-repeat; background-size:100% 100%">	
		<!-- position -->
		<div class="position">
   			 <a href="index.jsp">首页</a>   > <label>更改密码</label>
    	</div>
		<!-- content -->
		
		<div align="center">
			<h2>修改密码</h2>
			<s:form action="user_updatePassword" method="post" theme="xhtml">
				  用户名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.username}
				<s:password name="oldPassword" size="20" label="旧密码"/>
				<s:password name="newPassword" size="20" label="新密码"/>
				<s:password name="rePassword" size="20" label="确认新密码"/>
				<s:submit value="确认"/>
			</s:form>
		</div>

		
		
  </body>
</html>
