package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class exitSystem extends ActionSupport {
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		if(session.get("custLogin")!=null){
			session.remove("custLogin");
		}
		return SUCCESS;
	}
}
