package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.openclassrooms.PayMyBuddy.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionServ;

}
