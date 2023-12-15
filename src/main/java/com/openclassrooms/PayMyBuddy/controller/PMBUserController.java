package com.openclassrooms.PayMyBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.PayMyBuddy.model.Friend;
import com.openclassrooms.PayMyBuddy.model.PMBUser;
import com.openclassrooms.PayMyBuddy.service.PMBUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PMBUserController {
	
	@Autowired
	private PMBUserService userServ;
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	/**
	 * Display the form to create a new user
	 * @param model
	 * @return
	 */
	@GetMapping("/newUser")
	public String newUserAccess(Model model) {
        PMBUser user = new PMBUser();
        model.addAttribute("pmbuser", user);
		return "newUser";
	}
	
	/**
	 * Create a new user from the form
	 * @param model
	 * @param user
	 * @return
	 */
	@PostMapping("/newUser")
	public String createNewUser(Model model, @ModelAttribute("pmbuser") PMBUser user) {
		PMBUser userCheck = userServ.createNewUser(user);
		if( userCheck==null ) {
			return "redirect:/newUser?exist";
		}
		return "redirect:/login";
	}

	
	/**
	 * display the "home" page
	 * @param model
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/home")
	public String welcome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "home";
	}

	/**
	 * display the "profile" page
	 * @param model
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/profile")
	public String profile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		model.addAttribute("friendship", new Friend());
		return "profile";
	}
	
	/**
	 * display the form for the user to modify some information
	 * @param model
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/profile/modifUser")
	public String modifUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "modifUser";
	}
	
	/**
	 * change the information about the user from the form. logout because the password may have been changed
	 * @param model
	 * @param user
	 * @return
	 * @throws ServletException 
	 */
	@PostMapping("/profile/modifUser")
	public String changeUser(Model model, @AuthenticationPrincipal UserDetails userDetails, 
			@ModelAttribute("user") PMBUser user, HttpServletRequest request) throws ServletException {
		userServ.changeUser(userDetails, user);
		request.logout();
		return "redirect:/home?logout";
	}
	
	/**
	 * display the "contact" page
	 * @param model
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/contact")
	public String contact(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		userServ.filledWithUser(model, userDetails);
		return "contact";
	}
	
	/**
	 * send the message from the form in the "contact" page
	 * @param model
	 * @param userDetails
	 * @param message
	 * @return
	 */
	@PostMapping("/contact")
	public String message(Model model, @AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("message") String message) {
		userServ.contactMessage(message);
		return "redirect:/contact?message";
	}
	

}
