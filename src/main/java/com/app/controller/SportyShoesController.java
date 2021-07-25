package com.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Shoe;
import com.app.model.ShoeOrder;
import com.app.model.User;
import com.app.service.ShoeOrderService;
import com.app.service.ShoeService;
import com.app.service.UserService;

@Controller
@RequestMapping("/")
public class SportyShoesController {
	
	@Autowired
	ShoeService shoeSvc;
	
	@Autowired
	UserService userSvc;
	
	@Autowired
	ShoeOrderService orderSvc;
	
	@RequestMapping("/")
	public String homepage(Model model) {
		model.addAttribute("homeMessage", "This is the Sporty Shoes Homepage Message!!!");
		
		List<Shoe> shoes = new ArrayList<Shoe>();
		shoeSvc.getAllShoes().forEach(shoes::add);
		
		model.addAttribute("shoes",shoes);
		
		return "index";
	}
	
	@GetMapping("/purchase")
	public String purchaseShoe(@RequestParam("shoe") long shoeId, Model model, HttpSession session) {
		//make sure the user is logged in first
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			//redirect to user login
			user = new User();
			model.addAttribute("userObj", user);
			model.addAttribute("userLoginMsg", "Please login to continue.");
			session.setAttribute("redirect", "redirect:/purchase?shoe=" + shoeId);
			return "/user/user-login";
		}
		Shoe shoe = shoeSvc.getShoeById(shoeId);
		ShoeOrder order = new ShoeOrder(user, shoe, LocalDate.now());
		model.addAttribute("order", order);
		model.addAttribute("submitUri", "/purchase?shoe="+shoe.getShoeId());
		return "purchase";
	}
	
	@PostMapping("/purchase")
	public String makePurchase(@ModelAttribute("order")ShoeOrder order, Model model) {
		//could validate the order here
		orderSvc.saveOrder(order);
		model.addAttribute("order", order);
		return "purchase-summary";
	}
}
