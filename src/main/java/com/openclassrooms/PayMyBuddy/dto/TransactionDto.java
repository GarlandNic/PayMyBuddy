package com.openclassrooms.PayMyBuddy.dto;

import java.time.LocalDateTime;

import com.openclassrooms.PayMyBuddy.model.Transaction;

import lombok.Data;

@Data
public class TransactionDto {
	
	String senderEmail;
	
	String recipientEmail;
	
	int sendValue;
	
	int fee;
	
	LocalDateTime transferTime;
	
	String description;
	
	public TransactionDto(Transaction transaction) {
		this.senderEmail = transaction.getFriendship().getUser().getEmail();
		this.recipientEmail = transaction.getFriendship().getBuddy().getEmail();
		this.sendValue = transaction.getSentValueInCent();
		this.fee = transaction.getTaxedFeeInCent();
		this.transferTime = transaction.getTransferTime();
		this.description = transaction.getDescription();
	}
	
	public int getReceivedValueInCent() {
		return (this.sendValue - this.fee);
	}

}
