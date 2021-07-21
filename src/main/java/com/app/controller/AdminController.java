package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//the path under the pages folder where the admin jsp files can be found
	private static String adminPath = "/admin/";
	
	@RequestMapping("/")
	public String adminHomepage(HttpSession session) {
		
		
		//what happens when null is cast to a bool? do we get false?
		Boolean isAuthenticated = (Boolean) session.getAttribute("authenticated");

		//if there is no existing session, go to login page
		if(isAuthenticated != null && isAuthenticated.booleanValue() == true) {
			return adminPath + "admin";
		}
		else {
			return adminPath + "admin-login";
		}
		
	}

}
