<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="js/checkUpdateInfo.js"></script> 

  </head>
  
  <body background="Images/Sea.jpg"	style="background-repeat:no-repeat; background-size:100% 100%">
		
		<div class="position">
   			 <a href="main.jsp">��ҳ</a>    <label>�޸ĸ�����Ϣ</label>
    	</div>
    	
		<!-- content -->	
		<s:form action="user_updateInfo" method="post">
			<table>
				<tr>
					<td align="center"><s:textfield
							value="%{#session.user.username}" name="newName" label="�û���" /></td>
				</tr>
			

				<tr>
					<td align="center"><s:textfield
							value="%{#session.user.mobilePhone}" name="newPhone" label="��ϵ�绰" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td align="right" colspan="2"><input type="submit" value="�޸�" />&nbsp;
						<input type="reset" value="����" /></td>
				</tr>
			</table>

		</s:form>	
	
			
		<a href="user_changepwd.jsp">�޸�����</a>
			

  </body>
</html>
