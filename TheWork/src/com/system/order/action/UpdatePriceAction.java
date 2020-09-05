package com.system.order.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.dao.ConcertDao;
import com.system.concert.model.Concert;
import com.system.management.dao.TicketDao;
import com.system.management.model.Message;
import com.system.management.model.Seat;
import com.system.management.model.Ticket;
import com.system.order.dao.OrderDao;

import models.User;

public class UpdatePriceAction extends ActionSupport{
	public UpdatePriceAction(){
		
	}
	Concert concert;
	Message ms;
	List<Seat> set;
	public List<Seat> getSet() {
		return set;
	}

	public void setSet(List<Seat> set) {
		this.set = set;
	}
	Seat st;
	OrderDao od;
	ConcertDao cd;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	User user;
	public ConcertDao getCd() {
		return cd;
	}

	public void setCd(ConcertDao cd) {
		this.cd = cd;
	}

	public Seat getSt() {
		return st;
	}

	public void setSt(Seat st) {
		this.st = st;
	}

	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	public Message getMs() {
		return ms;
	}

	public void setMs(Message ms) {
		this.ms = ms;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

	public String execute(){
		st=od.queryByseat(ms.getRow(), ms.getCol(), concert.getTicketid());
		int ticketid=concert.getTicketid();
		concert=cd.queryConcertByTicketId(ticketid);
		Map session=ActionContext.getContext().getSession();
		user=(User)session.get("user");
		session.put("seat", st);
		session.put("concert", concert);
		set=cd.getSeat(ticketid);
		if(st!=null){
			
			if(concert!=null){
				if(user!=null){
					if(st.getStatus()!=1){
						if(set!=null){
							return SUCCESS;
						}else{
						return INPUT;
						}
					}else{
						return INPUT;
					}
					
				}else{
					return INPUT;
				}
			
			}else{
				return INPUT;
			}
		}else{
			return INPUT;
		}
	}

}
