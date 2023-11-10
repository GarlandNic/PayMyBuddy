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
import com.openclassrooms.PayMyBuddy.service.FriendService;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;
import com.openclassrooms.PayMyBuddy.service.TransactionService;
import com.openclassrooms.PayMyBuddy.service.BankService;

@Controller
public class BankController {
	
	@Autowired
	private PMBUserService userServ;
	
	@Autowired
	private BankService bankServ;
	
	@GetMapping("/home/credit")
	public String credit(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("creditdto", new CreditDto());
		return "credit";
	}
	
	@PostMapping("/home/credit")
	public String creditation(Model model, @ModelAttribute("creditdto") CreditDto creditDto, @AuthenticationPrincipal UserDetails userDetails) {
		boolean isOK = bankServ.creditation(creditDto, userServ.getPMBUser(userDetails));
		if(isOK) {
			return "redirect:/home";			
		} else {
//			userServ.filledWithUser(model, userDetails);
//			model.addAttribute("error", true);
			return "redirect:/credit?error";
		}
	}
	
	@GetMapping("/profile/debit")
	public String debit(Model model) {
		return "debit";
	}
	// Post TODO

}
