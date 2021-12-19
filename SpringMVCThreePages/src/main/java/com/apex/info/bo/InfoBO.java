package com.apex.info.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.info.dao.InfoDAO;
import com.apex.info.dao.InfoDAOInterface;
import com.apex.info.vo.User;


@Service
public class InfoBO implements InfoBOInterface {

	@Autowired
	InfoDAOInterface infoDao;
	public String addInfo(User user,String id) {
		String errors="";
		if(fieldIsNull(user.getFirstname()))
		  {
			  errors+="first name cannot be empty<br>";
		  }
		  if(fieldIsNull(user.getLastname()))
		  {
			  errors+="lastname name cannot be empty<br>";
		  }
		  if(fieldIsNull(user.getGender()))
		  {
			  errors+="Please select the gender<br>";
		  }
		  if(fieldcontainsNumber(user.getFirstname()))
		  {
			  errors+="first name cannot contain a  numeric value<br>";
		  }
		  if(fieldcontainsNumber(user.getMiddlename()))
		  {
			  errors+="middle name cannot contain a  numeric value<br>";
		  }
		  if(fieldcontainsNumber(user.getLastname()))
		  {
			  errors+="lastname name cannot contain a  numeric value<br>";
		  }

		  if(containsSpecialCharacters(user.getLastname()))
		  {
			  errors+="lastname name cannot contain a special character<br>";
		  }
		  if(containsSpecialCharacters(user.getFirstname()))
		  {
			  errors+="lastname name cannot contain a special character<br>";
		  }
		  if(containsSpecialCharacters(user.getMiddlename()))
		  {
			  errors+="lastname name cannot contain a special character<br>";
		  }
			/*
			 * if(errors=="") infoDao.addInfo(user, id);
			 */
		
		return errors;
	}
	boolean fieldIsNull(String fieldvalue) {
		return fieldvalue==null||fieldvalue.trim().length()==0;
	}
	private boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	private boolean fieldcontainsNumber(String fieldvalue) {
		return fieldvalue.matches(".*\\d.*");
	}
	public static boolean containsSpecialCharacters(String fieldvalue) {
	        	Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	        	Matcher hasSpecial = special.matcher(fieldvalue);
	        	return hasSpecial.find();
	           }
	@Override
	public String addBank(User user,User userAddress,User userPersonal) {
		String errors="";
		if(fieldIsNull(user.getAccount()))
		  {
			  errors+="account number cannot be empty<br>";
		  }
		if(fieldIsNull(user.getBank()))
		  {
			  errors+="bank name cannot be empty<br>";
		  }
		if(fieldIsNull(user.getSsn()))
		  {
			  errors+="ssn cannot be empty<br>";
		  }
		
		if(!isNumeric(user.getSsn()))
		{
			errors+="ssn must be set of numbers<br>";
		}
		if(containsSpecialCharacters(user.getAccount()))
		  {
			  errors+="account number cannot have special characters<br>";
		  }
		if(containsSpecialCharacters(user.getBank()))
		  {
			  errors+="bank name cannot have special characters<br>";
		  }
		if(containsSpecialCharacters(user.getSsn()))
		 {
			  errors+="SSN cannot have special characters<br>";
		  }
		if(fieldcontainsNumber(user.getBank()))
		{
			 errors+="Bank Name cannot have a special characters<br>";
		}
		if(errors=="")
			  //infoDao.addBank(user, userAddress,userPersonal);
			//infoDao.createUser(user, userAddress,userPersonal);
			infoDao.createUserOnWeb(user, userAddress,userPersonal);
		return errors;
	}
	
	public String addAddress(User user, String id) {
		String errors="";
		if(fieldIsNull(user.getAddress()))
		  {
			  errors+="address cannot be empty<br>";
		  }
		  if(fieldIsNull(user.getCity()))
		  {
			  errors+="city name cannot be empty<br>";
		  }
		  if(fieldIsNull(user.getCountry()))
		  {
			  errors+="country cannot be empty <br>";
		  }
		  if(fieldIsNull(user.getState()))
		  {
			  errors+="state cannot be empty <br>";
		  }
		  if(fieldIsNull(user.getPhone()))
		  {
			  errors+="phone cannot be empty <br>";
		  }
		  if(fieldcontainsNumber(user.getCity()))
		  {
			  errors+="city cannot contain a  numeric value<br>";
		  }
		  if(fieldcontainsNumber(user.getState()))
		  {
			  errors+="state cannot contain a  numeric value<br>";
		  }
		  if(fieldcontainsNumber(user.getCountry()))
		  {
			  errors+="country cannot contain a  numeric value<br>";
		  }
		  if(!isNumeric(user.getPhone()))
		  {
			  errors+="Phone can only be a numeric value<br>";
		  }
			/*
			 * if(errors=="") infoDao.addAddress(user, id);
			 */
		  return errors;
	}
	}

