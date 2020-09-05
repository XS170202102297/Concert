package com.system.management.action;

import javax.xml.ws.Response;

import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;
import com.system.management.model.Ticket;

public class AddTicketAction extends ActionSupport{
	Ticket ticket;
	TicketDao td;
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public TicketDao getTd() {
		return td;
	}
	public void setTd(TicketDao td) {
		this.td = td;
	}
	public String execute() throws Exception{
		
		if(td.addTicket(ticket)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
