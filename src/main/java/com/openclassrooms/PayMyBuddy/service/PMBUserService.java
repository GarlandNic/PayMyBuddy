package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;

@Service
public class PMBUserService {
	
	@Autowired
	private PMBUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	/**
	 * request to create a new PMBUser in the DB. the password is encrypted.
	 * @param user
	 * @return
	 */
	public PMBUser createNewUser(PMBUser user) {
		Optional<PMBUser> existingUser = userRepo.findByEmail(user.getEmail());
		
		if(existingUser.isPresent()) {
			return null;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(user) ;
		}
	}

	/**
	 * request to get the user's information from the DB
	 * @param userDetails
	 * @return
	 */
	public PMBUser getPMBUser(UserDetails userDetails) {
		Optional<PMBUser> user = userRepo.findByEmail(userDetails.getUsername());
		return user.get();	
	}
	
	/**
	 * request to get a user's information from it's email
	 * @param email
	 * @return
	 */
	public PMBUser getPMBUserByEmail(String email) {
		Optional<PMBUser> user = userRepo.findByEmail(email);
		return (user.isPresent() ? user.get() : null);	
	}

	/**
	 * request to save a user in the DB
	 * @param userDetails 
	 * @param user
	 * @return
	 */
	public PMBUser changeUser(UserDetails userDetails, PMBUser user) {
		PMBUser oldUser = userRepo.findByEmail(userDetails.getUsername()).get();
		if(!oldUser.getEmail().equals(user.getEmail())) return user;
		oldUser.setNickname(user.getNickname());
		oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(oldUser) ;
	}

	/**
	 * request to delete a user
	 * @param user
	 */
	public void supprUser(PMBUser user) {
		userRepo.delete(user);		
	}

	/**
	 * From the contact form. Should send the message to the right people. Do nothing yet.
	 * @param message
	 */
	public void contactMessage(String message) {
	}
	
	/**
	 * update the Model with information about the user from the DB
	 * @param model
	 * @param userDetails
	 * @return
	 */
	public PMBUser filledWithUser(Model model, UserDetails userDetails) {
		PMBUser user = this.getPMBUser(userDetails);
		model.addAttribute("user", user);
		return user;
	}
}
