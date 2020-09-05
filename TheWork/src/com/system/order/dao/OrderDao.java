package com.system.order.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.system.concert.model.Concert;
import com.system.management.model.Seat;
import com.system.management.model.Ticket;
import com.system.order.model.Order;


public class OrderDao {
	public OrderDao(){
		
	}
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Seat queryByseat(int row,int col,int cid){
		Session session=null;
		try{
			Seat seat=null;
			session=sessionFactory.openSession();
			String queryString="from Seat where row =? and col=? and cid=?";
			Query query=session.createQuery(queryString);
			query.setString(0, ""+row+"排");
			query.setString(1, ""+col+"座");
			query.setInteger(2, cid);
			seat=(Seat)query.uniqueResult();
			return seat;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public Seat queryseat(int sid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Seat seat=(Seat)session.get(Seat.class, sid);
			return seat;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public Concert queryBycon(String ticketName){
		Session session=null;
		try{
			Concert concert=null;
			session=sessionFactory.openSession();
			String queryString="from Concert where ticketName=?";
			Query query=session.createQuery(queryString);
			query.setString(0, ticketName);
			
			
			concert=(Concert)query.uniqueResult();
			return concert;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public int addOrder(int uid,int sid,String ticketname,String seat){
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			//根据Bean工厂里产生的sessionFactory获得session对象
			session=sessionFactory.openSession();
			Order order=new Order();
			order.setUid(uid);
			order.setSid(sid);
			order.setTicketName(ticketname);
			order.setSeat(seat);
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(order).toString());
			transaction.commit(); //写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	public boolean deleteOd(int sid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="delete Order where sid=?";
			Query query=session.createQuery(queryString);
			query.setInteger(0, sid);
			boolean issuccess = (query.executeUpdate() > 0);
	    	return issuccess;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
	public List<Order> queryOrder(int uid){
		//得到session
		Session session=null;
		try{
			//根据Bean工厂里产生的sessionFactory获得session对象
			session=sessionFactory.openSession();
			String queryString="from Order where uid='"+uid+"'";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List<Order> list=query.list();
			if(list.size()>0)
				return list;
			else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}
	}
	public List<Order> queryorderByPage(int uid,int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Order where uid='"+uid+"'";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引，第一页显示的第一条数据的索引为0，第二页的第一条数据的索引为5
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//设施这一页最多显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Order> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public Order queryorderById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Order order=(Order)session.get(Order.class, id);
			return order;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public boolean Setstauts(String row,String col,int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Seat set status=? where row=? and col=? and cid=?";
			Query query=session.createQuery(queryString);
			query.setInteger(0, 1);
			query.setString(1, row);
			query.setString(2, col);
			query.setInteger(3, cid);
			boolean issuccess = (query.executeUpdate() > 0);
	    	return issuccess;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
	public boolean Destauts(int sid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="update Seat set status=? where sid=?";
			Query query=session.createQuery(queryString);
			query.setInteger(0, 0);
			query.setInteger(1, sid);
			boolean issuccess = (query.executeUpdate() > 0);
	    	return issuccess;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
	}
	
	
}
