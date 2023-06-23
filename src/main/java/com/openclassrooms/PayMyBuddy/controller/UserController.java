package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.PayMyBuddy.model.User;
import com.openclassrooms.PayMyBuddy.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userLogin")
	public void login() {
	}
	
	@PostMapping("/user")
	public void createNewUser(@ModelAttribute User user) {
		userService.createNewUser(user);
		 
		// check pwd identiques
		// check si email déja dans la base
		// add nouvel user
	}

}
