package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.system.management.dao.CustomerDao;
import com.system.management.model.Customer;


public class RegAction extends ActionSupport{
	private Customer custRegister;
	private CustomerDao ad;
	
	public RegAction(){
		
	}
	
	public Customer getCustRegister() {
		return custRegister;
	}

	public void setCustRegister(Customer custRegister) {
		this.custRegister = custRegister;
	}

	
	public CustomerDao getAd() {
		return ad;
	}

	public void setAd(CustomerDao ad) {
		this.ad = ad;
	}

	public String execute()throws Exception{
	
		if(ad.registerUser(custRegister)>0){			
			return SUCCESS;
		}else{
			addFieldError("custRegister.username","用户名错误");
			addFieldError("custRegister.password","密码错误");
			return INPUT; 
		}
	}
	
}


