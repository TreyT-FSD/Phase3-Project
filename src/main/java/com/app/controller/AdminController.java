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
import com.app.service.ShoeService;
import com.app.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	//autowired Admin Service
	@Autowired
	AdminService adminSvc;
	
	@Autowired
	ShoeService shoeSvc;
	
	@Autowired
	UserService userSvc;
	
//	@Autowired
//	OrderService orderSvc;
	
	@GetMapping("/")
	public String adminHomepage(HttpSession session, Model model) {		

		Admin admin = (Admin) session.getAttribute("admin");

		if(admin != null) {
			model.addAttribute("shoes", shoeSvc.getAllShoes());
			model.addAttribute("users", userSvc.getAllUsers());
			model.addAttribute("admin", admin);
			return "/admin/admin";
		}
		else {
			admin = new Admin();
			model.addAttribute("adminObj",admin);
			return "/admin/admin-login";
		}
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(@ModelAttribute("adminObj") Admin admin, Model model, HttpSession session) {
		
		//check to see if the creds match the admin creds
		if(adminSvc.authenticateAdmin(admin)) {
			//set them as authenticated user
			Admin sessionAdmin = adminSvc.getAdminByAdminUsername(admin);
			sessionAdmin.setAdminPwd("");
			
			session.setAttribute("admin", sessionAdmin);
			session.setAttribute("adminAuthenticated", true);
			return "redirect:/admin/";
		}
		else {
			model.addAttribute("adminLoginMsg", "Invalid Password");
			return "/admin/admin-login";
		}
	}
	
	@GetMapping("/logout")
	public String adminLogout(HttpSession session) {
		session.setAttribute("admin", null);
		session.setAttribute("adminAuthenticated", false);
		session.setAttribute("adminLoginMsg", null);
		session.setAttribute("passwordActionMsg", null);
		return "redirect:/";
	}
	
	@PostMapping("/changeAdminPassword")
	public String changeAdminPassword(@ModelAttribute("admin")Admin updatedAdmin, HttpSession session, Model model) {
		Admin admin = adminSvc.getAdminById(updatedAdmin.getAdminId());
		
		admin.setAdminPwd(updatedAdmin.getAdminPwd());
		
		Admin resultAdmin = adminSvc.saveAdmin(admin);
		
		if(resultAdmin != null) {
			model.addAttribute("passwordActionMsg", "Password Updated.");
			model.addAttribute("shoes", shoeSvc.getAllShoes());
			model.addAttribute("users", userSvc.getAllUsers());
			return "/admin/admin";
		}
		model.addAttribute("passwordActionMsg", "Password update failed.");
		model.addAttribute("shoes", shoeSvc.getAllShoes());
		model.addAttribute("users", userSvc.getAllUsers());
		return "/admin/admin";
		
		
	}

}
