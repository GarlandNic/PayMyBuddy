package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.service.FriendService;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendServ;
	
	@Autowired
	private PMBUserService userServ;
	
	@GetMapping("/transfer/addFriend")
	public String addFriendForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Friend buddy = new Friend();
        buddy.setUserEmail(userDetails.getUsername());
        model.addAttribute("buddy", buddy);
		userServ.filledWithUser(model, userDetails);
		return "addFriend";
	}
	
	@PostMapping("/transfer/addFriend")
	public String addFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, Friend buddy) {
		buddy.setUserEmail(userDetails.getUsername());
        friendServ.save(buddy);
		return "redirect:/transfer";
	}

}
