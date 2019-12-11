package com.project.dao;

import com.project.model.User;

public interface UserDao {
	
	public boolean addUser(User uObj);
	public User validateUser(String email, String password);
	public User gettingSeller();
	public User gettingBuyer(int id);

}
