package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.dto.CreditDto;
import com.openclassrooms.PayMyBuddy.dto.PayBuddyDto;
import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.FriendService;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;
import com.openclassrooms.PayMyBuddy.service.TransactionService;

@Controller
public class PMBUserController {
	
	@Autowired
	private PMBUserService userServ;
	
	@Autowired
	private TransactionService transactionServ;
	
	@Autowired
	private FriendService friendServ;
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/newUser")
	public String newUserAccess(Model model) {
        PMBUser user = new PMBUser();
        model.addAttribute("pmbuser", user);
		return "newUser";
	}
	
	@PostMapping("/newUser")
	public String createNewUser(Model model, @ModelAttribute("pmbuser") PMBUser user) {
		PMBUser userCheck = userServ.createNewUser(user);

		if( userCheck==null ) {
//			model.addAttribute("exist", true);
			return "redirect:/newUser?exist";
		}

		return "redirect:/login";
	}

	
	@GetMapping("/home")
	public String welcome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "home";
	}

	@GetMapping("/profile")
	public String profile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		friendServ.filledWithFriends(model, userDetails);
		return "profile";
	}
	
	@GetMapping("/profile/modifUser")
	public String modifUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "modifUser";
	}
	
	@PostMapping("/profile/modifUser")
	public String changeUser(Model model, @ModelAttribute("pmbuser") PMBUser user) {
		userServ.changeUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/contact")
	public String contact(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "contact";
	}
	// Post TODO
	

}
