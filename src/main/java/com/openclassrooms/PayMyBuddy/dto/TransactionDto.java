package com.openclassrooms.PayMyBuddy.dto;

import java.time.LocalDateTime;

import com.openclassrooms.PayMyBuddy.model.Transaction;

import lombok.Data;

@Data
public class TransactionDto {
	
	String senderEmail;
	
	String recipientEmail;
	
	String senderNickname;
	
	String recipientNickname;
	
	int sendValue;
	
	int fee;
	
	LocalDateTime transferTime;
	
	String description;
	
	/**
	 * Create a TransactionDto object from a Transaction (DB) object
	 * @param transaction
	 */
	public TransactionDto(Transaction transaction) {
		this.senderEmail = transaction.getFriendship().getUser().getEmail();
		this.senderNickname = transaction.getFriendship().getUser().getNickname();
		this.recipientEmail = transaction.getFriendship().getBuddy().getEmail();
		this.recipientNickname = transaction.getFriendship().getBuddy().getNickname();
		this.sendValue = transaction.getSentValueInCent();
		this.fee = transaction.getTaxedFeeInCent();
		this.transferTime = transaction.getTransferTime();
		this.description = transaction.getDescription();
	}
	
	public TransactionDto() {
	}

	/**
	 * Compute the received money from sendValue and fee
	 * @return
	 */
	public int getReceivedValue() {
		return (this.sendValue - this.fee);
	}

}
