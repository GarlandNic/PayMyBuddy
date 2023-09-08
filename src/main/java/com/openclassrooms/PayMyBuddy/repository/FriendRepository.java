package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.PayMyBuddy.model.Friend;

public interface FriendRepository extends CrudRepository<Friend, Integer> {

}
