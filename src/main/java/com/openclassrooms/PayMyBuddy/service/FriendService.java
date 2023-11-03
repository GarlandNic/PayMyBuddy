package com.openclassrooms.PayMyBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.repository.FriendRepository;

@Service
public class FriendService {
	
	@Autowired
	private FriendRepository friendRepo;

	public Iterable<Friend> getFriendList(String username) {
		return friendRepo.findByUserEmail(username);
	}

	public void save(Friend buddy) {
		friendRepo.save(buddy);
	}

	public void filledWithFriends(Model model, UserDetails userDetails) {
		model.addAttribute("buddyList", this.getFriendList(userDetails.getUsername()));		
	}

}
