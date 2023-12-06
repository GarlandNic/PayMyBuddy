package com.openclassrooms.PayMyBuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.dto.FriendDto;
import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;

@Service
public class PMBUserService {
	
	@Autowired
	private PMBUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public PMBUser createNewUser(PMBUser user) {
		Optional<PMBUser> existingUser = userRepo.findByEmail(user.getEmail());
		
		if(existingUser.isPresent()) {
			return null;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(user) ;
		}
	}

	public PMBUser getPMBUser(UserDetails userDetails) {
		Optional<PMBUser> user = userRepo.findByEmail(userDetails.getUsername());
		return user.get();	
	}
	
	public PMBUser getPMBUserByEmail(String email) {
		Optional<PMBUser> user = userRepo.findByEmail(email);
		return (user.isPresent() ? user.get() : null);	
	}
	
	public PMBUser filledWithUser(Model model, UserDetails userDetails) {
		PMBUser user = this.getPMBUser(userDetails);
		model.addAttribute("user", user);
		return user;
	}

	public PMBUser changeUser(PMBUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user) ;
	}

	public void supprUser(PMBUser user) {
		userRepo.delete(user);		
	}

	public Friend FriendDtoToFriend(FriendDto buddy, PMBUser pmbUser) {
		Friend friend = new Friend();
		friend.setUser(pmbUser);
		friend.setBuddy(userRepo.findByEmail(buddy.getFriendEmail()).get());
		return friend;
	}

	public void contactMessage(String message) {
		// Send the message to the rigth people
	}

}
