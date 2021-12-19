package com.apex.info.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.apex.info.util.HibernateUtil;
import com.apex.info.vo.User;
import com.apex.info.vo.UserRest;

@Repository
public class InfoDAO implements InfoDAOInterface {

	@Override
	public void addInfo(User user, String id) {
		Connection dbConn = null;
		PreparedStatement pStmt = null;
		try {
			dbConn = getConnection();
			pStmt = dbConn.prepareStatement(
					"INSERT INTO test.userdetails(iduserdetails,firstname,middlename,lastname,gender) VALUES(?,?,?,?,?)");
			pStmt.setString(1, id);
			pStmt.setString(2, user.getFirstname());
			pStmt.setString(3, user.getLastname());
			pStmt.setString(4, user.getLastname());
			pStmt.setString(5, user.getGender());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				pStmt.close();
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}  }
		
	}

	public void createUser(User user, User userAddress, User userPersonal) {
		user.setUserId(String.valueOf(Math.random()));
		user.setAddress(userAddress.getAddress());
		user.setCity(userAddress.getCity());
		user.setState(userAddress.getAddress());
		user.setCountry(userAddress.getCountry());
		user.setAddress(userAddress.getAddress());
		user.setFirstname(userPersonal.getFirstname());
		user.setLastname(userPersonal.getLastname());
		user.setMiddlename(userPersonal.getMiddlename());
		user.setGender(userPersonal.getGender());
		user.setPhone(userAddress.getPhone());
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit(); 
	}
	
	@Override
	public void addBank(User user, User userAddress, User userPersonal) {
		Connection dbConn = null;
	    PreparedStatement pStmt = null;
	   		     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO test.userdetails VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String s=String.valueOf(Math.random()); 
		pStmt.setString(1, s);
		pStmt.setString(2, userPersonal.getFirstname());
		pStmt.setString(3, userPersonal.getLastname());
		pStmt.setString(4, userPersonal.getMiddlename());
		pStmt.setString(5, userPersonal.getGender());
		pStmt.setString(6, userAddress.getAddress());
		pStmt.setString(7, userAddress.getCity());
		pStmt.setString(8, userAddress.getState());
		pStmt.setString(9, userAddress.getCountry());
		pStmt.setString(10, userAddress.getPhone());
		pStmt.setString(11, user.getBank());
		pStmt.setString(12, user.getAccount());
		pStmt.setString(13, user.getSsn());
		//pStmt.setString(4, id);
   		pStmt.executeUpdate();
	     }catch (SQLException sqle) {

		   sqle.printStackTrace();

		}
             catch(Exception e) {
		   e.printStackTrace();

		}
	     finally {
		try {
			pStmt.close();
			dbConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	     }
		
	}

	@Override
	public void addAddress(User user, String id) {
		Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    		     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("update test.userdetails set address=?,city=?,state=?,country=?,phone=? where iduserdetails=?");
		pStmt.setString(1, user.getAddress());
		pStmt.setString(2, user.getCity());
		pStmt.setString(3, user.getState());
		pStmt.setString(4, user.getCountry());
		pStmt.setString(5, user.getPhone());
		pStmt.setString(6, id);
   		pStmt.executeUpdate();
	     }catch (Exception sqle) {
		   sqle.printStackTrace();
		}
            
	     finally {
		try {
			pStmt.close();
			dbConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	     }
		
	}

	public static Connection getConnection() throws Exception {
		Connection dbConn = null;
		try {
			// step1:
			Class.forName("com.mysql.jdbc.Driver");
			// step2
			String url = "jdbc:mysql://localhost:3306/test";
			// step3
			dbConn = DriverManager.getConnection(url, "root", "nishantaggarwal");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}

	
	public void createUserOnWeb(User user, User userAddress, User userPersonal) {
		UserRest userRest=new UserRest();
		userRest.setId((int) Math.random());
		userRest.setCity(userAddress.getCity());
		userRest.setState(userAddress.getAddress());
		userRest.setCountry(userAddress.getCountry());
		userRest.setAddress(userAddress.getAddress());
		userRest.setFirstName(userPersonal.getFirstname());
		userRest.setLastName(userPersonal.getLastname());
		userRest.setMiddleName(userPersonal.getMiddlename());
		userRest.setGender(userPersonal.getGender());
		userRest.setPhoneNumber(userAddress.getPhone());
		userRest.setBankName(user.getBank());
		userRest.setAccount(user.getAccount());
		userRest.setSsn(user.getSsn());
		String urlForPost1="http://localhost:8080/SpringRestApiCrudOperations/users";
		RestTemplate restTemplate1 = new RestTemplate();
		restTemplate1.postForObject(urlForPost1, userRest, User.class);
	}


}
