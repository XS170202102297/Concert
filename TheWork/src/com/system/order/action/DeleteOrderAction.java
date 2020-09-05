package com.system.order.action;

import com.opensymphony.xwork2.ActionSupport;
import com.system.order.dao.OrderDao;

public class DeleteOrderAction extends ActionSupport{
	public DeleteOrderAction(){
		
	}
	private int sid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	OrderDao od;
	public OrderDao getOd() {
		return od;
	}
	public void setOd(OrderDao od) {
		this.od = od;
	}
	public String execute(){
		if(od.deleteOd(sid)){
			if(od.Destauts(sid)){
				return SUCCESS;
			}else{
				return INPUT;
			}
			
		}else{
			return INPUT;
		}
	}
}

