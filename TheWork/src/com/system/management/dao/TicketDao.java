package com.system.management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.system.management.model.Ticket;

public class TicketDao {
	public TicketDao(){
		
	}
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public int addTicket(Ticket ticket){
		int num=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		try{
			//根据Bean工厂里产生的sessionFactory获得session对象
			session=sessionFactory.openSession();
			
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(ticket).toString());
			transaction.commit();//写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	public List<Ticket> queryConcert(){
		//得到session
		Session session=null;
		try{
			//根据Bean工厂里产生的sessionFactory获得session对象
			session=sessionFactory.openSession();
			String queryString="from Ticket";
			//创建查询
			Query query=session.createQuery(queryString);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List<Ticket> list=query.list();
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
	public List<Ticket> queryByPage(int pageNo,int pageSize){
		//得到session
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Ticket";
			Query query=session.createQuery(queryString);
			//每次获取第一条数据的索引，第一页显示的第一条数据的索引为0，第二页的第一条数据的索引为5
			query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
			//设施这一页最多显示的记录个数
			query.setMaxResults(pageSize); 

			//每次最多5条记录
			List<Ticket> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public Ticket queryTicketById(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Ticket ticket=(Ticket)session.get(Ticket.class, id);
			return ticket;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
	public boolean deleteCon(int id){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Ticket ticket=(Ticket)session.get(Ticket.class, id);
			Transaction trans=session.beginTransaction();
			session.delete(ticket);
			trans.commit();
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}
		
	}
	public boolean updateTicket(Ticket ticket){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			session.update(ticket);
			trans.commit();
			return true;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}

}
