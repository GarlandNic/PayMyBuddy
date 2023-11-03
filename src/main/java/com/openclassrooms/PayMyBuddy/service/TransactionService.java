package com.openclassrooms.PayMyBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.model.Transaction;
import com.openclassrooms.PayMyBuddy.repository.TransactionRepository;

@Service
public class TransactionService {
	
	static final double TAXE=0.005;
	
	@Autowired
	private TransactionRepository transactionRepo;

	private Iterable<Transaction> getTransferIncomes(String username) {
		return transactionRepo.findByRecipientEmail(username);
	}

	private Iterable<Transaction> getTransferOutcomes(String username) {
		return transactionRepo.findBySenderEmail(username);
	}


	public void filledWithIncomes(Model model, UserDetails userDetails) {
		model.addAttribute("incomesList", this.getTransferIncomes(userDetails.getUsername()));
	}

	public void filledWithOutcomes(Model model, UserDetails userDetails) {
		model.addAttribute("outcomesList", this.getTransferOutcomes(userDetails.getUsername()));
	}

	public int computeFee(int sendValue) {
		return (int) Math.ceil(sendValue*TAXE);
	}

	public void save(Transaction transaction) {
		transactionRepo.save(transaction);
	}

}
