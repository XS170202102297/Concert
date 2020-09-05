package dao;

import java.util.List;


import models.User;


public interface UserDao {

	public int addUser(User user);
	

	public User checkLogin(User user);
	
	
	public boolean updatePassword(String newPassword,User user);
	
	
	public User showInfo(int userId);

	public boolean updateInfo(User user);
	



}
