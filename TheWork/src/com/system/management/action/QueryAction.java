package com.system.management.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.management.dao.TicketDao;
import com.system.management.model.Ticket;


public class QueryAction extends ActionSupport{
	public QueryAction(){
		
	}
	List<Ticket> tk;
	TicketDao td;
	public TicketDao getTd() {
		return td;
	}
	public void setTd(TicketDao td) {
		this.td = td;
	}
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始显示
	private int currentPage; //当前页
	private int totalPage; //总页数
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
	public int getPageSize() {
		return pageSize;
	}
	public List<Ticket> getTk() {
		return tk;
	}
	public void setTk(List<Ticket> tk) {
		this.tk = tk;
	}

	public String execute(){
		tk=td.queryConcert();
		if(tk.size()%pageSize==0){
			totalPage=tk.size()/pageSize;
		}else{//取模有余数，总页数+1
			totalPage=tk.size()/pageSize+1;
		}
		//控制页码不会越界
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页码，查询要在该页上显示的5条数据，users集合里仅包括当前页要显示的user数据
		tk=td.queryByPage(pageNo,pageSize);
		//设置当前页
		currentPage=pageNo;
		if(tk!=null){
		return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
