package com.assigment.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.apex.user.util.HibernateUtil;
import com.assigment.entity.User;

//import dbaccess.MYSQLDBAccess;

@Repository
public class UserDaoImpl implements UserDAO {

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx =  session.beginTransaction();
		User user = session.get(User.class, id);
		
		System.out.println("user in Dao:" + user);
		
//		tx.commit();
		session.close();
		
		
		return user;
	}

	@Override
	public void addUser(User user) {
		
		System.out.println("UserDAOImpl :addUser: Start ");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		session.save(user);
		tx.commit();
		
		System.out.println("UserDAOImpl :addUser: end");	

	}

	
	public void updateUser(User user) {
		
		System.out.println("UserDaoImpl :updateUser: Start ");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
		
//		session.get(User.class, user.getId());
		
		session.update(user);
		
//		System.out.println("user in Dao:" + user);
		
		tx.commit();
		session.close();
		
		System.out.println("UserDaoImpl :updateUser: End ");

	}

	@Override
	public void deleteUser(int id) {
		
		System.out.println("UserDaoImpl :deleteUser: end");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =  session.beginTransaction();
//		session.update(user);
		
		User user = session.get(User.class, id);
		
		session.delete(user);
		
//		System.out.println("user in Dao:" + user);
		
		tx.commit();
		session.close();
		
		System.out.println("UserDaoImpl :deleteUser: end");

	}

	
}
