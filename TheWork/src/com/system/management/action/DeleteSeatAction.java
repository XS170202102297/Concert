package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.SeatDao;
import com.system.management.model.Seat;
import com.system.management.model.Ticket;

public class DeleteSeatAction extends ActionSupport{
	public DeleteSeatAction(){
		
	}
	Seat seat;
	SeatDao sd;
	Ticket ticket;
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public SeatDao getSd() {
		return sd;
	}
	public void setSd(SeatDao sd) {
		this.sd = sd;
	}
	public String execute(){
		Map map=ActionContext.getContext().getSession();
		ticket=(Ticket)map.get("ticket");
		
		if(sd.delete(seat,ticket.getTicketid())){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
