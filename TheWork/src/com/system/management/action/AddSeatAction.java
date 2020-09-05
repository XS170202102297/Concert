package com.system.management.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.SeatDao;
import com.system.management.model.Message;
import com.system.management.model.Seat;
import com.system.management.model.Ticket;

public class AddSeatAction extends ActionSupport{
	Seat seat;
	Ticket ticket;
	Message ms;
	SeatDao sd;
	public SeatDao getSd() {
		return sd;
	}
	public void setSd(SeatDao sd) {
		this.sd = sd;
	}
	public Message getMs() {
		return ms;
	}
	public void setMs(Message ms) {
		this.ms = ms;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public String execute() throws Exception{
		Map map=ActionContext.getContext().getSession();
		ticket=(Ticket)map.get("ticket");
		int id=ticket.getTicketid();
		float p=seat.getPrice();
		if(sd.addSeat(id, ms.getRow(), ms.getCol(), p)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}


}
