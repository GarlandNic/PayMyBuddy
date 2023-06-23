package com.openclassrooms.PayMyBuddy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.User;

@Service
public class UserService {
	
	public void login() {
		
	}
	
	public User createNewUser(String email, String pwd1, String pwd2) {
		// check pwd identiques
		// check si email déja dans la base
		// add nouvel user
		return new User();
	}

}
