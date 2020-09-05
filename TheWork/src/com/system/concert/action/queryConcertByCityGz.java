package com.system.concert.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.system.concert.dao.ConcertDao;
import com.system.concert.model.Concert;

public class queryConcertByCityGz extends ActionSupport{
	List<Concert> concerts; 
	ConcertDao cd;
		
	public queryConcertByCityGz(){
			
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
	
	public String execute(){
		concerts=cd.getConcertByGz();
		if(concerts.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}	
	}
}
