<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="js/checkUpdateInfo.js"></script> 

  </head>
  
  <body background="Images/Sea.jpg"	style="background-repeat:no-repeat; background-size:100% 100%">
		
		<div class="position">
   			 <a href="main.jsp">首页</a>    <label>修改个人信息</label>
    	</div>
    	
		<!-- content -->	
		<s:form action="user_updateInfo" method="post">
			<table>
				<tr>
					<td align="center"><s:textfield
							value="%{#session.user.username}" name="newName" label="用户名" /></td>
				</tr>
			

				<tr>
					<td align="center"><s:textfield
							value="%{#session.user.mobilePhone}" name="newPhone" label="联系电话" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td align="right" colspan="2"><input type="submit" value="修改" />&nbsp;
						<input type="reset" value="重置" /></td>
				</tr>
			</table>

		</s:form>	
	
			
		<a href="user_changepwd.jsp">修改密码</a>
			

  </body>
</html>
