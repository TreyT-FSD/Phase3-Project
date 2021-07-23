package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userSvc;
	
	@GetMapping("/")
	public String userHome(Model model, HttpSession session) {
		//see if the user has already logged in
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("loggedInUserMsg",
					"Welcome " + user.getUserFirstName() + ". Please return to the homepage to purchase products.");
			return "/user/user";
		} else {
			return "redirect:/user/login";
			
		}		
	}
	
	@GetMapping("/login")
	public String userLogin(Model model) {
		User user = new User();
		model.addAttribute("userObj", user);
		return "/user/user-login";
	}
	
	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute("userObj") User user, Model model, HttpSession session) {
		
		//check to see if this user is in the DB
		if(userSvc.isAuthenticatedUser(user)) {
			//update their session to show logged in
			session.setAttribute("user", userSvc.getUserByEmail(user));
			
			//update the model with their user details so we can show them a message
			model.addAttribute("user", user);
			
			return "redirect:/user/";
			
		} else {
			user = new User();
			model.addAttribute("userObj", user);
			model.addAttribute("userLoginMsg", "Email or password was invalid.");
			return "/user/user-login";
		}
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}
	
	@GetMapping("/registration")
	public String registerUser(Model model) {
		User user = new User();
		model.addAttribute("userObj", user);
		return "/user/user-registration";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("userObj") User user, Model model, HttpSession session) {
		
		//TODO: probably should do some input validation on what the user just entered
		userSvc.AddUser(user);
		session.setAttribute("user", userSvc.getUserByEmail(user));
		
		return "redirect:/user/";
	}

}
