package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;

@Service
public class PMBUserService {
	
	@Autowired
	private PMBUserRepository userRepo;
	
	public PMBUser createNewUser(PMBUser user) {
		
		Optional<PMBUser> existingUser = userRepo.findById(user.getEmail());
		
		if(existingUser.isPresent()) {
			return null;
		} else {
			return userRepo.save(user) ;
		}
	}

//	public boolean checkUser(PMBUser user) {
//		
//		Optional<PMBUser> existingUser = userRepo.findById(user.getEmail());
//		
//		if(existingUser.isPresent()) {
//			if( existingUser.get().getPassword().equals(user.getPassword()) ) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}		
//	}

}
