package dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;
import models.User;


public class UserDaoImp implements UserDao{

	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Session session=null;
		Transaction transaction=null;
		int n=0;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			n= Integer.parseInt(session.save(user).toString());
			transaction.commit();
			session.close();
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			return n;
		}
	}

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session = sessionFactory.openSession();
			Query query=session.createQuery("from User where username=? and password=?)");
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List<User> list=query.list();
			session.close();
			if(list.size()>0){
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updatePassword(String newPassword, User user) {
		// TODO Auto-generated method stub
		System.out.println("修改密码中");
		Boolean flag = false;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			user.setPassword(newPassword);
			session.update(user);
			System.out.println("修改密码成功");
			flag = true;
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			session.close();
		}
		return flag;

	}

	

	@Override
	public User showInfo(int id2) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User c = null;
		try{
			tx = session.beginTransaction();
			c = (User)session.get("models.User", id2);
			session.update(c);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		return c;
	
	}

	@Override
	public boolean updateInfo(User user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(user);
			flag = true;
			System.out.println("修改成功");
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}




	
}
