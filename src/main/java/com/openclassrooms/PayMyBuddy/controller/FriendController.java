package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        boolean isOk = friendServ.save(buddy);
        if(isOk) {
    		return "redirect:/transfer";
        } else {
        	// message
    		return "redirect:/transfer/addFriend";
        }
	}
	
    @PostMapping(value = "/profile/friend", params = "modify")
	public String modifFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("buddy") Friend buddy, @RequestParam(required = true) String modify) {
		buddy.setUserEmail(userDetails.getUsername());
        friendServ.save(buddy);
		return "redirect:/profile";
	}

    @PostMapping(value = "/profile/friend", params = "remove")
	public String supprFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("buddy") Friend buddy, @RequestParam(required = true) String remove) {
		buddy.setUserEmail(userDetails.getUsername());
        friendServ.deleteFriend(buddy);
		return "redirect:/profile";
	}

}
