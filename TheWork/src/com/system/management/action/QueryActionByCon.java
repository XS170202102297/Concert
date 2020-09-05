package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;
import com.system.management.model.Ticket;

public class QueryActionByCon extends ActionSupport{
	public QueryActionByCon(){
		
	}
	Ticket ticket;
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	int id;
	TicketDao td;

	public TicketDao getTd() {
		return td;
	}

	public void setTd(TicketDao td) {
		this.td = td;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String execute(){
		ticket=td.queryTicketById(id);
		if(ticket!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}

