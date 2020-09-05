package Action;
import com.opensymphony.xwork2.ActionSupport;
import Dao.BookingDao;
import Model.Booking;

public class updateTicket extends ActionSupport{
	private Booking book;
	BookingDao bd;

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
		if(bd.updateTicket(book)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
