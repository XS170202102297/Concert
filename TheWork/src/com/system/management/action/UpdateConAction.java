package com.system.management.action;

import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;
import com.system.management.model.Ticket;

public class UpdateConAction extends ActionSupport{
	public UpdateConAction(){
		
	}
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
	public String execute(){
		if(td.updateTicket(ticket)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
