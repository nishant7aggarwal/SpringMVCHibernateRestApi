package com.assigment.bo;

import com.assigment.entity.User;

public interface UserBO {

	public User getUser(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	
	
}
