package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Admin;
import com.app.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//autowired Admin Service
	@Autowired
	AdminService adminSvc;
	
	//the path under the pages folder where the admin jsp files can be found
	private static String adminPath = "/admin/";
	
	@GetMapping("/")
	public String adminHomepage(HttpSession session, Model model) {		

		Boolean isAuthenticated = (Boolean) session.getAttribute("authenticated");

		if(isAuthenticated != null && isAuthenticated.booleanValue() == true) {
			return adminPath + "admin";
		}
		else {
			Admin admin = new Admin();
			model.addAttribute("adminObj",admin);
			return adminPath + "admin-login";
		}
		
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(@ModelAttribute("adminObj") Admin admin, Model model, HttpSession session) {
		
		//check to see if the creds match the admin creds
		if(adminSvc.authenticateAdmin(admin)) {
			//set them as authenticated user
			session.setAttribute("authenticated", true);
			return adminPath + "admin";
		}
		else {
			model.addAttribute("adminLoginMsg", "Invalid Password");
			return adminPath + "admin-login";
		}
	}
	
	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
