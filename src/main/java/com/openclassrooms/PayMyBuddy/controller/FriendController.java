package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.openclassrooms.PayMyBuddy.service.FriendService;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService friendServ;

}
