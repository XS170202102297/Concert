package com.system.management.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.system.management.model.Booking;

public class BookingDao {
	SessionFactory sessionFactory;
	
	public BookingDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public List<Booking> getBooking(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Booking ";
			Query query=session.createQuery(queryString);

			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	public List<Booking> getBookingByPage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Booking";
			Query query=session.createQuery(queryString);
			query.setFirstResult((pageNo-1)*pageSize); 
			query.setMaxResults(pageSize); 
			List<Booking> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	public int addBooking(Booking book){
		Session session=null;
		Transaction transaction=null;
		int num=0; 
		try{
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			num=Integer.parseInt(session.save(book).toString());
			trans.commit(); 
		}catch(Exception ex){
			ex.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	public boolean updateTicket(Booking newBooking){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();

			session.update(newBooking); 
			trans.commit();

			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}finally{
			session.close();
		}	
	}
	
	public boolean deleteTicketById(int id2){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Booking book=(Booking)session.get(Booking.class, id2);
			Transaction trans=session.beginTransaction();
			session.delete(book);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public Booking queryTicketById(int id2){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Booking book=(Booking)session.get(Booking.class, id2);
			return book;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	public List<Booking> queryTicketByCriteria(Booking book){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Booking.class);
			criteria.add(Expression.eq("username",book.getUsername()));
			
			List list = criteria.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}
