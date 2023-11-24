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

import com.openclassrooms.PayMyBuddy.dto.FriendDto;
import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.FriendService;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendServ;
	
	@Autowired
	private PMBUserService userServ;
	
	/**
	 * Display the form to add a new friend
	 */
	@GetMapping("/transfer/addFriend")
	public String addFriendForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
//		PMBUser user = userServ.getPMBUser(userDetails);
//		FriendDto buddy = new FriendDto();
//        buddy.setUser(user);
//        model.addAttribute("user", user);
//        model.addAttribute("buddy", buddy);
		userServ.filledWithUser(model, userDetails);
		return "addFriend";
	}
	
	/**
	 * @param model
	 * @param userDetails
	 * @param buddy
	 * @return
	 */
	@PostMapping("/transfer/addFriend")
	public String addFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("friendEmail") String friendEmail) {
		Friend friend = new Friend();
		friend.setUser(userServ.getPMBUser(userDetails));
		friend.setBuddy(userServ.getPMBUserByEmail(friendEmail));
        boolean isOk = friendServ.save(friend);
        if(isOk) {
    		return "redirect:/transfer";
        } else {
        	// add message ?
    		return "redirect:/transfer/addFriend?error";
        }
	}
	
//    @PostMapping(value = "/profile/friend", params = "modify")
//	public String modifFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, 
//			@ModelAttribute("buddy") Friend buddy, @RequestParam(required = true) String modify) {
//		buddy.setUser(userServ.getPMBUser(userDetails));
//		friendServ.save(buddy);
//		return "redirect:/profile";
//	}

    @PostMapping(value = "/profile/friend", params = "remove")
	public String supprFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("friend") Friend buddy, @RequestParam(required = true) String remove) {
		buddy.setUser(userServ.getPMBUser(userDetails));
		friendServ.deleteFriend(buddy);
		return "redirect:/profile";
	}

}
