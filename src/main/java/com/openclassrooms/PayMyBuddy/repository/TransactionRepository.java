package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.PayMyBuddy.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
