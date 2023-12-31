package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.service.PMBUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import com.openclassrooms.PayMyBuddy.dto.CreditDto;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.BankService;

@Controller
public class BankController {
	
	@Autowired
	private PMBUserService userServ;
	
	@Autowired
	private BankService bankServ;
	
	/** 
	 * Display the page where user can credit his account
	 */
	@GetMapping("/home/credit")
	public String credit(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("creditdto", new CreditDto());
		return "credit";
	}
	
	/**
	 * The user fill the form with how much he want to credit his account, and from which bank account
	 * @param creditDto
	 * @return send to home if ok, or stay here if not
	 */
	@PostMapping("/home/credit")
	public String creditation(Model model, @ModelAttribute("creditdto") CreditDto creditDto, @AuthenticationPrincipal UserDetails userDetails) {
		boolean isOK = bankServ.creditation(creditDto, userServ.getPMBUser(userDetails));
		if(isOK) {
			return "redirect:/home";			
		} else {
			return "redirect:/home/credit?error";
		}
	}
	
	/**
	 * Display the page where user can debit his account
	 */
	@GetMapping("/profile/debit")
	public String debit(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("creditdto", new CreditDto());
		return "debit";
	}
	
	/**
	 * The user fill the form with how much he want to debit his account, and to which bank account
	 * @param creditDto
	 * @return send to profile
	 */
	@PostMapping("/profile/debit")
	public String debitation(Model model, @ModelAttribute("creditdto") CreditDto creditDto, @AuthenticationPrincipal UserDetails userDetails) {
		bankServ.debitation(creditDto, userServ.getPMBUser(userDetails));
		return "redirect:/profile";
	}

	/**
	 * Button to fill the debit form with the max
	 * @param model
	 * @param creditDto
	 * @param userDetails
	 * @return
	 */
	@PostMapping(value = "/profile/debit", params="everything")
	public String confirmEverything(Model model, @ModelAttribute("creditdto") CreditDto creditDto, @AuthenticationPrincipal UserDetails userDetails) {
		PMBUser user = userServ.getPMBUser(userDetails);
		creditDto.setValue(user.getBalanceInCent()/100);
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("creditdto", creditDto);
		return "debit";
	}
	
	/**
	 * button to confirm the total debitation and the suppression of the user
	 * @param model
	 * @param creditDto
	 * @param userDetails
	 * @return
	 * @throws ServletException 
	 */
	@PostMapping(value = "/profile/debit", params="everythingSure")
	public String debitationTotal(Model model, @ModelAttribute("creditdto") CreditDto creditDto, 
			@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) throws ServletException {
		PMBUser user = userServ.getPMBUser(userDetails);
		creditDto.setValue(user.getBalanceInCent()/100);
		bankServ.debitation(creditDto, user);
		userServ.supprUser(user);
		request.logout();
		return "redirect:/home?logout";
	}

}
