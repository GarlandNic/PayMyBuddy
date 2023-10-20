package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

import jakarta.annotation.security.RolesAllowed;

@Controller
public class PMBUserController {
	
	@Autowired
	private PMBUserService userServ;
		
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
			model.addAttribute("exist", true);
			return "newUser";
		}

		return "login";
	}
	
	
	@GetMapping("/home")
	public String welcome(Model model) {
		return "home";
	}
	
	@GetMapping("/home/credit")
	public String credit(Model model) {
		return "credit";
	}
	// Post
	
	@GetMapping("/transfer")
	public String transfer(Model model) {
		return "transfer";
	}
	// Post
	
	@GetMapping("/transfer/addFriend")
	public String addFriend(Model model) {
        Friend buddy = new Friend();
        model.addAttribute("friend", buddy);
		return "addFriend";
	}
	// Post
	
	@GetMapping("/profile")
	public String profile(Model model) {
		return "profile";
	}
	
	@GetMapping("/profile/debit")
	public String debit(Model model) {
		return "debit";
	}
	// Post
	
	@GetMapping("/profile/modifUser")
	public String modifUser(Model model) {
		return "modifUser";
	}
	// Post
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	// Post

}
