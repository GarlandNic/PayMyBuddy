package com.openclassrooms.PayMyBuddy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.PayMyBuddy.model.Friend;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {

}
