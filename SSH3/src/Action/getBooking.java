package Action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Dao.BookingDao;
import Model.Booking;


public class getBooking extends ActionSupport{
	List<Booking> books; 
	BookingDao bd;
	private Booking b;
	private int id; 
	private final int pageSize=6; 
	private int pageNo=1;
	private int currentPage; 
	private int totalPage;
	
	public getBooking(){
		
	}
	
	public List<Booking> getBooks() {
		return books;
	}
	public void setBooks(List<Booking> books) {
		this.books = books;
	}
	public BookingDao getBd() {
		return bd;
	}
	public void setBd(BookingDao bd) {
		this.bd = bd;
	}
	public Booking getB() {
		return b;
	}
	public void setB(Booking b) {
		this.b = b;
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
	public int getPageSize() {
		return pageSize;
	}
	
	public String execute()throws Exception{
		books=bd.getBooking();
		
		if(books.size()%pageSize==0){
			totalPage=books.size()/pageSize;
		}else{
			totalPage=books.size()/pageSize+1;
		}
		
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		books=bd.getBookingByPage(pageNo,pageSize);
	
		currentPage=pageNo;
		if(books!=null){
			
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
