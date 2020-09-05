package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class userExitAction extends ActionSupport{

 public String execute(){
  HttpServletRequest request = ServletActionContext.getRequest();
  HttpSession session = request.getSession();
  String exit = request.getParameter("exit");  //标志 当值为“true”时 退出
  
  if(exit.equals("true")){
	//清除session里相关的信息
	   session.removeAttribute("user");   //清除顾客信息
	   session.removeAttribute("order");   //清除订单
   
  }
  return SUCCESS;
 }
}