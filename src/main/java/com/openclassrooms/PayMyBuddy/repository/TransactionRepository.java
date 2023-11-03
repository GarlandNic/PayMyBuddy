package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	Iterable<Transaction> findBySenderEmailOrRecipientEmail(String senderName, String recipientName);

}
