package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.CreditDto;
import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

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
	public String welcome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		filledWithUser(model, userDetails);
		return "home";
	}
	
	@GetMapping("/home/credit")
	public String credit(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		filledWithUser(model, userDetails);
		return "credit";
	}
	@PostMapping("/home/credit")
	public String creditation(Model model, @ModelAttribute("creditdto") CreditDto creditDto, @AuthenticationPrincipal UserDetails userDetails) {
		boolean isOK = userServ.creditation(creditDto, userDetails);
		if(isOK) {
			filledWithUser(model, userDetails);
			return "home";			
		} else {
			filledWithUser(model, userDetails);
			model.addAttribute("error", true);
			return "credit";
		}
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		return "profile";
	}
	
	@GetMapping("/profile/debit")
	public String debit(Model model) {
		return "debit";
	}
	// Post TODO
	
	@GetMapping("/profile/modifUser")
	public String modifUser(Model model) {
		return "modifUser";
	}
	// Post TODO
	
	@GetMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	// Post TODO
	
	
	private void filledWithUser(Model model, UserDetails userDetails) {
		PMBUser user = userServ.getPMBUser(userDetails);
		model.addAttribute("user",user);
	}

}
