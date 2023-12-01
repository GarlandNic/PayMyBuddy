package com.openclassrooms.PayMyBuddy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.Friend;

public interface FriendRepository extends CrudRepository<Friend, Integer> {

	public Iterable<Friend> findByUserEmail(String username);

	public Optional<Friend> findByUserEmailAndBuddyEmail(String senderEmail, String recipientEmail);

}
