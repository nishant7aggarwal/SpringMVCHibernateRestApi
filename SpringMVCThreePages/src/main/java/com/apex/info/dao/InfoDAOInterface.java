package com.apex.info.dao;

import com.apex.info.vo.User;

public interface InfoDAOInterface {
	abstract public void addInfo(User user, String id);

	//public abstract void addBank(User user, String id);

	public abstract void addAddress(User user, String id);

	public abstract void addBank(User user, User userAddress, User userPersonal);
	public abstract void createUser(User user, User userAddress, User userPersonal);
	public abstract void createUserOnWeb(User user, User userAddress, User userPersonal);

}
