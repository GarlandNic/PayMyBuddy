package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	Iterable<Transaction> findByRecipientEmail(String username);

	Iterable<Transaction> findBySenderEmail(String username);

}
