package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.CreditDto;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;
import com.openclassrooms.PayMyBuddy.security.CustomUserDetailsService;

@Service
public class PMBUserService {
	
	@Autowired
	private PMBUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public PMBUser createNewUser(PMBUser user) {
		
		Optional<PMBUser> existingUser = userRepo.findById(user.getEmail());
		
		if(existingUser.isPresent()) {
			return null;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(user) ;
		}
	}

	public void creditation(CreditDto creditDto) {
		// check iban
		// mis à jour de la DB avec plus sur la balance 
		
	}

}
