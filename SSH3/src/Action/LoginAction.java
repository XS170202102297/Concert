package Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.CustomerDao;
import Model.Customer;

public class LoginAction extends ActionSupport{
	Customer custLogin; 
	CustomerDao cd;
	
	public LoginAction(){
		
	}

	public Customer getCustLogin() {
		return custLogin;
	}

	public void setCustLogin(Customer custLogin) {
		this.custLogin = custLogin;
	}

	
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public String execute()throws Exception{
		if(cd.loginUser(custLogin)){
			Map session=ActionContext.getContext().getSession();
			session.put("custLogin", custLogin);
			session.put("username", custLogin.username);
			return SUCCESS;
		}else{
			addFieldError("custLogin.username","用户名错误");
			addFieldError("custLogin.password","密码错误");
			return INPUT;
		}
	}
	
}
	