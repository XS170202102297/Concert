package com.system.management.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.SeatDao;
import com.system.management.model.Message;
import com.system.management.model.Seat;
import com.system.management.model.Ticket;

public class ASeatAction extends ActionSupport {
	public ASeatAction(){
		
	}
	Seat seat;
	Ticket ticket;
	Message ms;
	SeatDao sd;
	List<Seat> st;
	public List<Seat> getSt() {
		return st;
	}
	public void setSt(List<Seat> st) {
		this.st = st;
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
	public Message getMs() {
		return ms;
	}
	public void setMs(Message ms) {
		this.ms = ms;
	}
	public SeatDao getSd() {
		return sd;
	}
	public void setSd(SeatDao sd) {
		this.sd = sd;
	}
	public String execute() throws Exception{
		Map map=ActionContext.getContext().getSession();
		ticket=(Ticket)map.get("ticket");
		int id=ticket.getTicketid();
		st=sd.querySeat(ms.getRow(),id);
		int co=0;
		if(st==null){
			co=0;
		}else{
			co=(int)st.size();
		}
		
		float p=seat.getPrice();
		if(sd.adSeat(id, ms.getRow(), ms.getCol(), p, co)>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
