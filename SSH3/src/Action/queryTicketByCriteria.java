package Action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.BookingDao;
import Model.Booking;


public class queryTicketByCriteria extends ActionSupport{
	List<Booking> books;
	Booking book;
	BookingDao bd;

	public queryTicketByCriteria(){
		
	}
	
	public List<Booking> getBooks() {
		return books;
	}

	public void setBooks(List<Booking> books) {
		this.books = books;
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
		books=bd.queryTicketByCriteria(book);
		if(books.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
