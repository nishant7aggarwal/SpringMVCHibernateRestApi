package com.apex.info.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.apex.info.bo.InfoBOInterface;
import com.apex.info.vo.User;

@Controller
public class InfoController {
	 @Autowired InfoBOInterface infoBO;
	 
	@RequestMapping("/entryInfo.do")
	public String entryUserRegistration(@ModelAttribute User user ,@ModelAttribute String errors ) {
		System.out.println("entered controller");
		return "Personal";	
	}
	
	  @RequestMapping("/processInfo.do") 
	  public String UserRegistration(@ModelAttribute User user,Model model,HttpSession session) {
	  System.out.println("entered registration  and the entered firstname was:"+user.getFirstname()); 
		//  System.out.println("session id is:"+session.getId());
	  String errors=infoBO.addInfo(user,session.getId());
	  if(errors=="")
	  {
		  session.setAttribute("Personalinfo", user);
		  return "Address";
	  
	  }
	  else {
		model.addAttribute("errormsg", errors);
		return "Personal";  
	  }
	  }
	  @RequestMapping("/processAddress.do") 
	  public String AddressRegistration(@ModelAttribute User user,Model model,HttpSession session) {
	  System.out.println("entered address and firsname and address is :"+user.getFirstname()+user.getAddress()); 
		 // System.out.println("session id is:"+session.getId());
	  String errors=infoBO.addAddress(user,session.getId());
	  if(errors=="")
	  {
		  session.setAttribute("Address", user);
		  return "Bank";  
	  }
	   
	  else {
		model.addAttribute("errormsg", errors);
		return "Address";  
	  }
	  }
	  @RequestMapping("/processBank.do") 
	  public String BankRegistration(@ModelAttribute User user,Model model,HttpSession session) {
	  System.out.println("entered Bank and firstname address and bank is :"+user.getFirstname()+user.getAddress()+user.getBank()); 

	  User UserAddress=(User)session.getAttribute("Address");
	  User UserPersonal=(User)session.getAttribute("Personalinfo");
	 // System.out.println("session id is:"+session.getId());
	  String errors=infoBO.addBank(user,UserAddress,UserPersonal);
	  if(errors=="")
	  return "Success";  
	  else {
		model.addAttribute("errormsg", errors);
		return "Bank";  
	  }
	  }
	 
	 
}
