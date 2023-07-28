package com.openclassrooms.PayMyBuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.PayMyBuddy.repository.FriendRepository;

@Service
public class FriendService {
	
	@Autowired
	private FriendRepository friendRepo;

}
