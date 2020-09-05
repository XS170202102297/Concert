package com.system.management.action;

import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;

public class DeleteConAction extends ActionSupport{
	public DeleteConAction(){
		
	}
	private int id;
	TicketDao td;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TicketDao getTd() {
		return td;
	}
	public void setTd(TicketDao td) {
		this.td = td;
	}
	public String execute(){
		if(td.deleteCon(id)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
