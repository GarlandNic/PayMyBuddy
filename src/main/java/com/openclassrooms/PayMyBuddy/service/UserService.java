package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.User;
import com.openclassrooms.PayMyBuddy.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createNewUser(User user) {
		
		Optional<User> existingUser = userRepo.findById(user.getEmail());
		
		if(existingUser.isPresent()) {
			// message d'erreur
			return null;
		} else {
			return userRepo.save(user) ;
		}
	}

	public boolean checkUser(User user) {
		
		Optional<User> existingUser = userRepo.findById(user.getEmail());
		
		if(existingUser.isPresent()) {
			if( existingUser.get().getPassword().equals(user.getPassword()) ) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}		
	}

}
