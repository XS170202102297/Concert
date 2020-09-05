package com.system.order.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.order.dao.OrderDao;
import com.system.order.model.Order;

import models.User;

public class QueryOrderAction extends ActionSupport {
	public QueryOrderAction(){
		
	}
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
	List<Order> ord;
	Order order;
	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Order> getOrd() {
		return ord;
	}
	public void setOrd(List<Order> ord) {
		this.ord = ord;
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
	public int getPageSize() {
		return pageSize;
	}
	OrderDao od;
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		user=(User)session.get("user");
		ord=od.queryOrder(user.getId2());
		if(ord.size()%pageSize==0){
			totalPage=ord.size()/pageSize;
		}else{//取模有余数，总页数+1
			totalPage=ord.size()/pageSize+1;
		}
		//控制页码不会越界
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页码，查询要在该页上显示的5条数据，users集合里仅包括当前页要显示的user数据
		ord=od.queryorderByPage(user.getId2(), pageNo, pageSize);
		//设置当前页
		currentPage=pageNo;
		if(ord!=null){
		return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
