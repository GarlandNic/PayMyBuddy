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
	 * @param model
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/transfer/addFriend")
	public String addFriendForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("friend", new FriendDto());
		return "addFriend";
	}
	
	/**
	 * Add a new friendship relation from the form
	 * @param model
	 * @param userDetails
	 * @param buddy
	 * @return
	 */
	@PostMapping("/transfer/addFriend")
	public String addFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("friend") FriendDto friendDto) {
		Friend friend = new Friend();
		friend.setUser(userServ.getPMBUser(userDetails));
		PMBUser buddy = userServ.getPMBUserByEmail(friendDto.getFriendEmail());
		if(null==buddy) return "redirect:/transfer/addFriend?unknownFriend";
		friend.setBuddy(buddy);
        boolean isOk = friendServ.save(friend);
        if(isOk) {
    		return "redirect:/transfer";
        } else {
    		return "redirect:/transfer/addFriend?error";
        }
	}

    /**
     * remove a friendship relation
     * @param model
     * @param userDetails
     * @param buddy
     * @param remove
     * @return
     */
    @PostMapping(value = "/profile/friend", params = "remove")
	public String supprFriend(Model model, @AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("friendship") Friend buddy, @RequestParam(required = true) String remove) {
		buddy.setUser(userServ.getPMBUser(userDetails));
		friendServ.deleteFriend(buddy);
		return "redirect:/profile";
	}

}
