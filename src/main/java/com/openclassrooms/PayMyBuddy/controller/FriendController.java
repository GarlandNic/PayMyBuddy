package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.service.FriendService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendServ;
	
	@GetMapping("/transfer/addFriend")
	public String addFriend(Model model) {
        Friend buddy = new Friend();
        model.addAttribute("friend", buddy);
		return "addFriend";
	}
	// Post TODO

}
