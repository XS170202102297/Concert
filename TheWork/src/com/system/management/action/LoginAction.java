package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.system.management.dao.CustomerDao;
import com.system.management.model.Customer;

public class LoginAction extends ActionSupport{
	Customer custLogin; 
	CustomerDao ad;
	
	public LoginAction(){
		
	}

	public Customer getCustLogin() {
		return custLogin;
	}

	public void setCustLogin(Customer custLogin) {
		this.custLogin = custLogin;
	}

	
	public CustomerDao getAd() {
		return ad;
	}

	public void setAd(CustomerDao ad) {
		this.ad = ad;
	}

	public String execute()throws Exception{
		if(ad.loginUser(custLogin)){
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
	