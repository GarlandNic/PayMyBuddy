package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.PayMyBuddy.model.User;
import com.openclassrooms.PayMyBuddy.service.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@RolesAllowed("ADMIN")
    @GetMapping("/admin/users")
    public void viewAllUsers() {
    }
	
//	@PostMapping("/userLogin")
//	public String loginAccess() {
//		return "userLogin";
//	}

//	@GetMapping("/userLogin")
//	public void login() {
//	}
//	
//	@PostMapping("/userCreation")
//	public String newUserAccess() {
//		return "newUser";
//	}
	
//	@PostMapping("/newUser")
//	public void createNewUser(@ModelAttribute User user) {
//		userService.createNewUser(user);
//		 
//		// check pwd identiques -- en commentaire
//		// check si email déja dans la base
//		// add nouvel user
//	}

}
