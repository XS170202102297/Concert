<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body background="Images/Sea.jpg"	style="background-repeat:no-repeat; background-size:100% 100%">	
		<!-- position -->
		<div class="position">
   			 <a href="index.jsp">��ҳ</a>   > <label>��������</label>
    	</div>
		<!-- content -->
		
		<div align="center">
			<h2>�޸�����</h2>
			<s:form action="user_updatePassword" method="post" theme="xhtml">
				  �û���:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.username}
				<s:password name="oldPassword" size="20" label="������"/>
				<s:password name="newPassword" size="20" label="������"/>
				<s:password name="rePassword" size="20" label="ȷ��������"/>
				<s:submit value="ȷ��"/>
			</s:form>
		</div>

		
		
  </body>
</html>
