package com.assigment.bo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.dao.UserDAO;
import com.assigment.entity.User;

@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

//	@Transactional
	public void addUser(User user) {
		
		System.out.println("UserBOImpl :updateUser: Start ");
		
		userDao.addUser(user);
		
		System.out.println("UserBOImpl :updateUser: end");
	}

	@Override
	public void updateUser(User user) {
		
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		
		System.out.println("UserBOImpl :deleteUser: start");
		
		userDao.deleteUser(id);
		
		System.out.println("UserBOImpl :deleteUser: end");
	}

}
