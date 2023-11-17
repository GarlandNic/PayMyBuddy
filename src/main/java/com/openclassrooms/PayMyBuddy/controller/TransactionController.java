package com.openclassrooms.PayMyBuddy.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.dto.CreditDto;
import com.openclassrooms.PayMyBuddy.dto.PayBuddyDto;
import com.openclassrooms.PayMyBuddy.model.Transaction;
import com.openclassrooms.PayMyBuddy.service.FriendService;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;
import com.openclassrooms.PayMyBuddy.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	PMBUserService userServ;
	
	@Autowired
	private TransactionService transactionServ;
	
	@Autowired
	private FriendService friendServ;
	
	@GetMapping("/transfer")
	public String transfer(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		friendServ.filledWithFriends(model, userDetails);
		transactionServ.filledWithIncomes(model, userDetails);
		transactionServ.filledWithOutcomes(model, userDetails);
		model.addAttribute("transaction", new Transaction());
		return "transfer";
	}
	
	@PostMapping("/transfer")
	public String transferMoney(Model model, @AuthenticationPrincipal UserDetails userDetails, Transaction transaction) {
		if(transaction.getSentValueInCent()==0) {
			// message ?
		} else {
			transaction.setSentValueInCent(100*transaction.getSentValueInCent()); // convert euros in cents
			transaction.setFriendshipId(0);
			transaction.setTransferTime(LocalDateTime.now());
			transaction.setTaxedFeeInCent(transactionServ.computeFee(transaction.getSentValueInCent()));
			transactionServ.operation(transaction);
			// message de bien passe ?
		}
		return "redirect:/transfer";
	}

}
