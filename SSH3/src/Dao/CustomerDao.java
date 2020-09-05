package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Model.Customer;

public class CustomerDao {
	SessionFactory sessionFactory;
	
	public CustomerDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int registerUser(Customer custRegister){
		int num=0;
		
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(custRegister).toString());
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{
			session.close();
		}
		return num;
	}
	
	public boolean loginUser(Customer custLogin){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			//Customer是POJO类名，username、password是POJO属性
			String hql="from Customer where username=? and password=?";
			Query query=session.createQuery(hql);
		
			query.setParameter(0, custLogin.getUsername());
			query.setParameter(1, custLogin.getPassword());
			List list=query.list(); 
			if(list.size()>0){ 
				return true;
			}else{
				return false;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			session.close();
		
		}
	}
	
	public boolean changePassword(Customer custChange,String oldPassword,String newPassword){
		boolean flag=true;
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Customer where username=? and password=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, custChange.getUsername());
			queryObject.setParameter(1, oldPassword);
			List<Customer> list=queryObject.list();
			if(list.size()==0){
				flag=false;
			}else{
				custChange=list.get(0); 
				custChange.setPassword(newPassword);
				transaction=session.beginTransaction();
				session.update(custChange);
				transaction.commit();
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
}
