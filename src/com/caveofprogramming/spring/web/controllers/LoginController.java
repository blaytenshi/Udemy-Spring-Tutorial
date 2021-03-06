package com.caveofprogramming.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caveofprogramming.spring.web.dao.User;
import com.caveofprogramming.spring.web.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedout() {
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		
		model.addAttribute("user", new User());
		
		return "newaccount";
	}
	
	@RequestMapping("/admin") 
	public String showAdmin(Model model) {
		
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin";
		
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newaccount";
		} 
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		// Check if username exists, if exists throw error
		if (userService.exists(user.getUsername())) {
			System.out.println("Caught duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username", "_This username already exists!");
			return "newaccount";
		}
		
		try {
			userService.create(user);			
		} catch (DuplicateKeyException e) {
		// } catch (DataAccessException e) {
			// Find what type of error the exception throws because spring throws everything as a DataAccessException 
			// System.out.println(e.getClass());
			
			// Register a field error for the specified field of the current object using the given error description. 
			// First is field name; second is the error code, interpretable as a message key (made up yourself), third is the fallback default Message if message key is not found in a properties file.
			result.rejectValue("username", "DuplicateKey.user.username", "_This username already exists!");
			return "newaccount";
		}
		
		return "accountCreated";
	}
}
