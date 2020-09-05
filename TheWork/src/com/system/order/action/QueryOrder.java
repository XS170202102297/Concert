package com.system.order.action;

import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.model.Concert;
import com.system.management.model.Seat;
import com.system.order.dao.OrderDao;
import com.system.order.model.Order;

public class QueryOrder extends ActionSupport {
	public QueryOrder(){
		
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	Order order;
	OrderDao od;
	Seat seat;
	Concert concert;
	public String execute(){
		order=od.queryorderById(id);
		seat=od.queryseat(order.getSid());
		concert=od.queryBycon(order.getTicketName());
		if(order!=null){
			if(seat!=null){
				if(concert!=null){
					return SUCCESS;
				}else{
					return INPUT;
				}
			}else{
				return INPUT;
			}
		}
		return INPUT;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderDao getOd() {
		return od;
	}
	public void setOd(OrderDao od) {
		this.od = od;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Concert getConcert() {
		return concert;
	}
	public void setConcert(Concert concert) {
		this.concert = concert;
	}
}
