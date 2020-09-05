package com.system.concert.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.system.concert.model.Concert;
import com.system.management.model.Seat;




public class ConcertDao {
	SessionFactory sessionFactory;
	
	public ConcertDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//获取所有演唱会的信息
	public List<Concert> getConcert(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert ";
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
	
	//分页
	public List<Concert> getConcertsByPage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert ";
			Query query=session.createQuery(queryString);
			query.setFirstResult((pageNo-1)*pageSize); 
			query.setMaxResults(pageSize); 
			List<Concert> list=query.list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	
	//获得单个演唱会信息
	public List<Concert> queryConcertsByCriteria(Concert concert){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Concert.class);
			criteria.add(Restrictions.like("ticketName","%"+concert.getTicketName()+"%"));
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
	
	public List<Concert> getConcertOrderByPrice(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert order by price asc";
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
	
	public List<Concert> getConcertOrderByTime(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert order by day asc";
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
	
	public List<Concert> getConcertByBj(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert where place='北京'";
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
	
	public List<Concert> getConcertBySh(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert where place='上海'";
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
	
	public List<Concert> getConcertByGz(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert where place='广州'";
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
	
	public List<Concert> getConcertByMale(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert where kind like '%男%'";
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
	
	public List<Concert> getConcertByFemale(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Concert where kind like '%女%'";
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
	
	public Concert queryConcertByTicketId(int ticketId){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			Concert concert=(Concert)session.get(Concert.class,ticketId);
			return concert;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}	
	}
	public List<Seat> getSeat(int cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Seat where cid=? and status=0";
			Query query=session.createQuery(queryString);
			query.setInteger(0, cid);
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
}
