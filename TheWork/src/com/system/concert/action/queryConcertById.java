package com.system.concert.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.dao.ConcertDao;
import com.system.concert.model.Concert;
import com.system.management.model.Seat;

import models.User;
import utils.Config;

public class queryConcertById extends ActionSupport{

	private int ticketid;
	ConcertDao cd;
	Concert concert;
	User user;
	List<Seat> set;

	public List<Seat> getSet() {
		return set;
	}
	public void setSet(List<Seat> set) {
		this.set = set;
	}
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public ConcertDao getCd() {
		return cd;
	}
	public void setCd(ConcertDao cd) {
		this.cd = cd;
	}
	public Concert getConcert() {
		return concert;
	}
	public void setConcert(Concert concert) {
		this.concert = concert;
	}
	
	public String execute(){
		concert=cd.queryConcertByTicketId(ticketid);
		Map session=ActionContext.getContext().getSession();
		user=(User)session.get("user");
		set=cd.getSeat(ticketid);
		if(user!=null){
			if(concert!=null){
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
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
