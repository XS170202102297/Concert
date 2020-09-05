package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;
import com.system.management.model.Ticket;



public class QueryActionById extends ActionSupport{
	public QueryActionById(){
		
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
		Map map=ActionContext.getContext().getSession();
		map.put("ticket", ticket);
		if(ticket!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
