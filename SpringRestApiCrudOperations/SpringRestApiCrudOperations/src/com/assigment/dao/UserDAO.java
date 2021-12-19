package com.assigment.dao;

import com.assigment.entity.User;

public interface UserDAO {
	
	public User getUser(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
}
