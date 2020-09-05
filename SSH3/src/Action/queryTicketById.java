package Action;

import com.opensymphony.xwork2.ActionSupport;

import Dao.BookingDao;
import Model.Booking;


public class queryTicketById extends ActionSupport{
	Booking book;
    int id2;
	BookingDao bd;

	public queryTicketById(){
		
	}
	
	
	public Booking getBook() {
		return book;
	}


	public void setBook(Booking book) {
		this.book = book;
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
		book=bd.queryTicketById(id2);
		if(book!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
