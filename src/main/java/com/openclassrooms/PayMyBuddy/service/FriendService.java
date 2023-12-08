package com.openclassrooms.PayMyBuddy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.dto.UserDto;
import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.repository.FriendRepository;

@Service
public class FriendService {
	
	@Autowired
	private FriendRepository friendRepo;

	/**
	 * request the list of Friend from the user's email
	 * @param username
	 * @return
	 */
	public Iterable<Friend> getFriendList(String username) {
		return friendRepo.findByUserEmail(username);
	}

	/**
	 * request to save a Friend
	 * @param buddy
	 * @return
	 */
	public Friend save(Friend buddy) {
		return friendRepo.save(buddy);
	}

	/**
	 * request to delete a Friend in the DB
	 * @param buddy
	 */
	public void deleteFriend(Friend buddy) {
		Optional<Friend> friendDB = friendRepo.findByUserEmailAndBuddyEmail(buddy.getUser().getEmail(), buddy.getBuddy().getEmail());
		friendRepo.deleteById(friendDB.get().getFriendId());
	}

	/**
	 * update the Model with "buddyList", a list of UserDto corresponding to the people in a friendship relation with the user
	 * @param model
	 * @param userDetails
	 */
	public void filledWithFriends(Model model, UserDetails userDetails) {
		List<UserDto> buddyList = new ArrayList<>();
		this.getFriendList(userDetails.getUsername()).forEach(friend -> {
			buddyList.add(new UserDto(friend.getBuddy()));
		});;
		model.addAttribute("buddyList", buddyList);		
	}
}
