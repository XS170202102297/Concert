package Action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.BookingDao;
import Model.Booking;


public class addBooking extends ActionSupport{
	Booking book;
	BookingDao bd;

	public addBooking(){
		
	}
	public Booking getBook() {
		return book;
	}

	public void setBook(Booking book) {
		this.book = book;
	}

	
	public BookingDao getBd() {
		return bd;
	}

	public void setBd(BookingDao bd) {
		this.bd = bd;
	}

	public String execute(){
		if(bd.addBooking(book)>0){
			Map session=ActionContext.getContext().getSession();
			session.put("booking",book);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}

