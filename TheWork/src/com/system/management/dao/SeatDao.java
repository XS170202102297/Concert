package com.system.management.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.system.management.model.Seat;
import com.system.management.model.Ticket;

public class SeatDao {
	public SeatDao(){
		
	}
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public int addSeat(int id,int row,int col,float p){
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			//根据Bean工厂里产生的sessionFactory获得session对象
			session=sessionFactory.openSession();
			
			transaction=session.beginTransaction();
			for(int i=1;i<=row;i++){
				for(int j=1;j<=col;j++){
					Ticket ticket=(Ticket)session.get(Ticket.class, id);
					Seat seat=new Seat();
					seat.setTicket(ticket);
					//seat.setCid(id);
					seat.setRow(i+"排");
					seat.setCol(j+"座");
					seat.setPrice(p);
					seat.setStatus(0);
					num+=Integer.parseInt(session.save(seat).toString());
					transaction.commit();
					transaction=session.beginTransaction();
					
				}
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	public int adSeat(int id,int row,int col,float p,int c){
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			transaction=session.beginTransaction();
				for(int j=c;j<(c+col);j++){
					Ticket ticket=(Ticket)session.get(Ticket.class, id);
					Seat seat=new Seat();
					seat.setTicket(ticket);
					//seat.setCid(id);
					seat.setRow(row+"排");
					seat.setCol(j+1+"座");
					seat.setPrice(p);
					seat.setStatus(0);
					num+=Integer.parseInt(session.save(seat).toString());
					transaction.commit();
					transaction=session.beginTransaction();
					
				}
				
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	public List<Seat> querySeat(int row,int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Seat where row = ? and cid=?";
			Query query=session.createQuery(queryString);
			query.setString(0, ""+row+"排");
			query.setInteger(1, cid);
			
			List list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{////关闭session
			session.close();
		}
	}

	public boolean update(Seat seat,int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Seat set price=? where row =? and col=? and cid=?";
			Query query=session.createQuery(queryString);
			query.setFloat(0, seat.getPrice());
			query.setString(1, seat.getRow()+"排");
			query.setString(2, seat.getCol()+"座");
			query.setInteger(3,cid);
			boolean issuccess = (query.executeUpdate() > 0);
	    	return issuccess;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	public boolean delete(Seat seat,int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete Seat where row =? and col=? and cid=?";
			Query query=session.createQuery(queryString);
			query.setString(0, seat.getRow()+"排");
			query.setString(1, seat.getCol()+"座");
			query.setInteger(2, cid);
			boolean issuccess = (query.executeUpdate() > 0);
	    	return issuccess;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}	
	}
	
	
}
