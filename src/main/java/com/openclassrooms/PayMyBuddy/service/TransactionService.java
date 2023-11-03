package com.openclassrooms.PayMyBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.model.Transaction;
import com.openclassrooms.PayMyBuddy.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepo;

	public Iterable<Transaction> getTransferList(String username) {
		return transactionRepo.findBySenderEmailOrRecipientEmail(username, username);
		// je veux toutes les transactions qui concernent username, dans un sens comme dans l'autre
		// 
	}

}
