package com.system.concert.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.dao.ConcertDao;
import com.system.concert.model.Concert;


public class getConcertAction extends ActionSupport{
	List<Concert> concerts; 
	ConcertDao cd;
	private Concert c;
	private int ticketId; 
	private final int pageSize=4; 
	private int pageNo=1;
	private int currentPage; 
	private int totalPage;
	
	public getConcertAction(){
		
	}

	public List<Concert> getConcerts() {
		return concerts;
	}

	public void setConcerts(List<Concert> concerts) {
		this.concerts = concerts;
	}

	public ConcertDao getCd() {
		return cd;
	}

	public void setCd(ConcertDao cd) {
		this.cd = cd;
	}

	public Concert getC() {
		return c;
	}

	public void setC(Concert c) {
		this.c = c;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
	
	public String execute()throws Exception{
		concerts=cd.getConcert();
		
		if(concerts.size()%pageSize==0){
			totalPage=concerts.size()/pageSize;
		}else{
			totalPage=concerts.size()/pageSize+1;
		}
		
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		concerts=cd.getConcertsByPage(pageNo,pageSize);
	
		currentPage=pageNo;
		if(concerts!=null){
			
			return SUCCESS;
		}
		else{
			return SUCCESS;
		}
	}
}
