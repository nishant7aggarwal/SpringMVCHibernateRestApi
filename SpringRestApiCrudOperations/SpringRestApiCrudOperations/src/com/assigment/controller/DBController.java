package com.assigment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.bo.UserBO;
import com.assigment.entity.User;

@RestController()
public class DBController {
	
	@Autowired
	UserBO userBo;

	
	@GetMapping(value = "/users/{userId}", headers = "Accept=application/json")
	public User getUser(@PathVariable("userId") int id) {
		// TODO Auto-generated method stub
		
		System.out.println("UserBOImpl :addUser: Start ");
		
		
		return userBo.getUser(id);
	}

	@PostMapping(value = "/users", headers = "Accept=application/json")
	public void addUser(@RequestBody User user) {
		
		System.out.println("UserBOImpl :addUser: Start ");
		
		userBo.addUser(user);
		
		System.out.println("UserBOImpl :addUser: end");
	}

	@PutMapping(value = "/users", headers = "Accept=application/json")
	public void updateUser(@RequestBody User user) {
		
		System.out.println("Controller :updateUser: Start ");
		
		userBo.updateUser(user);
		
		System.out.println("Controller :updateUser: end");
	}

	@DeleteMapping(value = "/users/{userId}", headers = "Accept=application/json")
	public void deleteUser(@PathVariable("userId") int id) {
		
		System.out.println("Controller :deleteUser: Start ");
		
		userBo.deleteUser(id);
		
		System.out.println("Controller :deleteUser: end");

	}
	
}
