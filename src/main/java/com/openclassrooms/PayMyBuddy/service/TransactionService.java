package com.openclassrooms.PayMyBuddy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.openclassrooms.PayMyBuddy.dto.TransactionDto;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.model.Transaction;
import com.openclassrooms.PayMyBuddy.repository.FriendRepository;
import com.openclassrooms.PayMyBuddy.repository.PMBUserRepository;
import com.openclassrooms.PayMyBuddy.repository.TransactionRepository;

@Service
public class TransactionService {
	
	static final double TAXE=0.005;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private PMBUserRepository userRepo;

	@Autowired
	private FriendRepository friendRepo;

	/**
	 * request to get the list of Transaction which gave money to the user
	 * @param username
	 * @return
	 */
	private Iterable<Transaction> getTransferIncomes(String username) {
		return transactionRepo.findByFriendshipBuddyEmailOrderByTransferTimeDesc(username);
	}

	/**
	 * request to get the list of Transaction which the user gave money to
	 * @param username
	 * @return
	 */
	private Iterable<Transaction> getTransferOutcomes(String username) {
		return transactionRepo.findByFriendshipUserEmailOrderByTransferTimeDesc(username);
	}


	/**
	 * update the Model with the List of TransactionDto which gave money to the user
	 * @param model
	 * @param userDetails
	 */
	public void filledWithIncomes(Model model, UserDetails userDetails) {
		List<TransactionDto> incomesList = new ArrayList<>();
		this.getTransferIncomes(userDetails.getUsername()).forEach(trans -> {
			incomesList.add(new TransactionDto(trans));
		});
		model.addAttribute("incomesList", incomesList);
	}

	/**
	 * update the Model with the List of TransactionDto which the user gave money to
	 * @param model
	 * @param userDetails
	 */
	public void filledWithOutcomes(Model model, UserDetails userDetails) {
		List<TransactionDto> outcomesList = new ArrayList<>();
		this.getTransferOutcomes(userDetails.getUsername()).forEach(trans -> {
			outcomesList.add(new TransactionDto(trans));
		});
		model.addAttribute("outcomesList", outcomesList);
	}

	/**
	 * compute the fee, from the constant TAXE
	 * @param sendValue
	 * @return
	 */
	public int computeFee(int sendValue) {
		return (int) Math.ceil(sendValue*TAXE);
	}

	/**
	 * operate a transaction : decrease account's user, increase account's friend, save user, friend and transaction
	 * @param transaction
	 */
	@Transactional
	public void operation(Transaction transaction) {
		PMBUser sender = transaction.getFriendship().getUser();
		sender.decreaseAccount(transaction.getSentValueInCent());
		userRepo.save(sender);
		transactionRepo.save(transaction);
		PMBUser recipient = transaction.getFriendship().getBuddy();
		recipient.increaseAccount(transaction.getReceivedValueInCent());
		userRepo.save(recipient);
	}
	
	/**
	 * convert a TransactionDto (form) to a Transaction (DB)
	 * @param transDto
	 * @return
	 */
	public Transaction transToDB(TransactionDto transDto) {
		Transaction trans = new Transaction();
		trans.setDescription(transDto.getDescription());
		trans.setSentValueInCent(transDto.getSendValue());
		trans.setTaxedFeeInCent(transDto.getFee());
		trans.setTransferTime(transDto.getTransferTime());
		trans.setFriendship(friendRepo.findByUserEmailAndBuddyEmail(transDto.getSenderEmail(), transDto.getRecipientEmail()).get());
		return trans;
	}

}
