package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.system.management.dao.CustomerDao;
import com.system.management.model.Customer;

public class changePasswordAction extends ActionSupport{
	String oldPassword;
	String newPassword;
	String newPassword2;
	Customer custChange; 
	CustomerDao ad ;
	
	public changePasswordAction(){
		
	}

	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getNewPassword2() {
		return newPassword2;
	}


	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}


	public Customer getCustChange() {
		return custChange;
	}


	public void setCustChange(Customer custChange) {
		this.custChange = custChange;
	}


	public CustomerDao getAd() {
		return ad;
	}


	public void setAd(CustomerDao ad) {
		this.ad = ad;
	}


	public String execute(){
		
		Map map=ActionContext.getContext().getSession();
		custChange=(Customer)map.get("custLogin");
		if(ad.changePassword(custChange, oldPassword, newPassword)){
			return SUCCESS;
		}else{
			addFieldError("oldPassword","旧密码错误");
			return INPUT;
		}
	}
}
