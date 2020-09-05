package Action;

import com.opensymphony.xwork2.ActionSupport;

import Dao.BookingDao;
import Model.Booking;

public class deleteTicket extends ActionSupport{
	private int id2;
	BookingDao bd;

	public deleteTicket(){
		
	}
	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public BookingDao getBd() {
		return bd;
	}

	public void setBd(BookingDao bd) {
		this.bd = bd;
	}
	
	public String execute(){
		if(bd.deleteTicketById(id2)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
