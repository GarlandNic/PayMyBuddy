package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

import jakarta.annotation.security.RolesAllowed;

@Controller
public class PMBUserController {
	
	@Autowired
	private PMBUserService userServ;
	
//	@RolesAllowed("ADMIN")
//    @GetMapping("/admin/users")
//    public void viewAllUsers() {
//    }
		
	@GetMapping("/login")
	public String login(Model model) {
        PMBUser user = new PMBUser();
        model.addAttribute("pmbuser", user);
		return "login";
	}
	
	@GetMapping("/newUser")
	public String newUserAccess(Model model) {
        PMBUser user = new PMBUser();
        model.addAttribute("user", user);
		return "newUser";
	}
	
	@GetMapping("/home")
	public String welcome(Model model) {
		return "home";
	}
	
	@PostMapping("/newUser")
	public String createNewUser(@ModelAttribute PMBUser user) {
		PMBUser userCheck = userServ.createNewUser(user);

		if( userCheck==null ) {
			// avec un message d'erreur ? comment ?
			return "newUser";
		}

		return "home";
	}
	
//	@PostMapping("/login")
//	public String loginAccess(@ModelAttribute PMBUser user) {
//		boolean isOK = userServ.checkUser(user);
//		
//		return "home";
//	}

}
