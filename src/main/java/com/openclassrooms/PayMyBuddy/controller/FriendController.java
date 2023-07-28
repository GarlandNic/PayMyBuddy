package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.PayMyBuddy.service.FriendService;

@RestController
public class FriendController {
	
	@Autowired
	private FriendService friendServ;

}
