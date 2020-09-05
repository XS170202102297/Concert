package com.system.order.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.model.Concert;
import com.system.management.model.Seat;
import com.system.order.dao.OrderDao;
import com.system.order.model.Order;

import models.User;

public class AddOrderAction extends ActionSupport{
	public AddOrderAction(){
		
	}
	Order order;
	Seat seat;
	Concert concert;
	public Concert getConcert() {
		return concert;
	}
	public void setConcert(Concert concert) {
		this.concert = concert;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	User user;
	OrderDao od;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderDao getOd() {
		return od;
	}
	public void setOd(OrderDao od) {
		this.od = od;
	}
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		user=(User)session.get("user");
		seat=(Seat)session.get("seat");
		concert=(Concert)session.get("concert");
		String str=seat.getRow()+seat.getCol();
		String row=seat.getRow();
		String col=seat.getCol();
		int cid=concert.getTicketid();
		if(od.addOrder(user.getId2(), seat.getSid(),concert.getTicketName(),str)>0){
			if(od.Setstauts(row, col, cid)){
				return SUCCESS;
			}else{
			return INPUT;
			}
		}else{
			return INPUT;
		}
	}
}
