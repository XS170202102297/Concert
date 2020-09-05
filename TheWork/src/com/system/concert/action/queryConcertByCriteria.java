package com.system.concert.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.dao.ConcertDao;
import com.system.concert.model.Concert;

public class queryConcertByCriteria extends ActionSupport{
	List<Concert> concerts; 
	Concert concert;
	ConcertDao cd;

	public queryConcertByCriteria(){
		
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

	


	public Concert getConcert() {
		return concert;
	}



	public void setConcert(Concert concert) {
		this.concert = concert;
	}



	public String execute(){
		concerts=cd.queryConcertsByCriteria(concert);
		if(concerts.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
