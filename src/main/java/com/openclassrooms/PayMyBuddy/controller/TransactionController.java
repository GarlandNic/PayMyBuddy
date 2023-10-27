package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassrooms.PayMyBuddy.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionServ;
	
	@GetMapping("/transfer")
	public String transfer(Model model) {
		return "transfer";
	}
	// Post TODO

}
