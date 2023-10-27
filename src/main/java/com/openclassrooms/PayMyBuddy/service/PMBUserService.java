package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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

	public boolean creditation(CreditDto creditDto, UserDetails userDetails) {
		// check iban
		userDetails.getUsername();
		// mis à jour de la DB avec plus sur la balance 
		// TODO
		return false;
	}

	public PMBUser getPMBUser(UserDetails userDetails) {
		Optional<PMBUser> user = userRepo.findByEmail(userDetails.getUsername());
		return user.get();	
	}

}
