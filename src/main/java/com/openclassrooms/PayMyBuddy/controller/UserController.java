package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.User;
import com.openclassrooms.PayMyBuddy.service.UserService;

import jakarta.annotation.security.RolesAllowed;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
//	@RolesAllowed("ADMIN")
//    @GetMapping("/admin/users")
//    public void viewAllUsers() {
//    }
		
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/newUser")
	public String newUserAccess(Model model) {
        User user = new User();
        model.addAttribute("user", user);
		return "newUser";
	}
	
	@GetMapping("/home")
	public String welcome(Model model) {
		return "home";
	}
	
	@PostMapping("/newUser")
	public String createNewUser(@ModelAttribute User user) {
		userServ.createNewUser(user);
		// check si email déja dans la base

		return "home";
	}
	
//	@PostMapping("/login")
//	public String loginAccess() {
//		return "userLogin";
//	}

//	@GetMapping("/userLogin")
//	public void login() {
//	}


}
