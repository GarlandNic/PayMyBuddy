package com.openclassrooms.PayMyBuddy.service;

import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.User;

@Service
public class UserService {
	
	public void login() {
		
	}
	
	public User createNewUser(User user) {
		
		// check pwd identiques
		// check si email déja dans la base
		// add nouvel user dans la base de donnée
		return user;
	}

}
