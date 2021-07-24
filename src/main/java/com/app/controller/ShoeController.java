package com.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Admin;
import com.app.model.Shoe;
import com.app.model.ShoeCategory;
import com.app.service.ShoeService;

@Controller
@RequestMapping("/shoe")
public class ShoeController {
	
	@Autowired
	ShoeService shoeSvc;
	
	
	@GetMapping("/{shoeId}")
	public String getShoe(@PathVariable long shoeId, Model model) {
		//make sure the user that is about to view this page is an admin?
		Shoe shoe = shoeSvc.getShoeById(shoeId);
		
		model.addAttribute("shoe", shoe);
		model.addAttribute("submitUri", "/shoe/" + shoe.getShoeId());
		
		List<ShoeCategory> enumValues = Arrays.asList(ShoeCategory.values());
		model.addAttribute("shoeCategories", enumValues);
		
		return "/shoe/shoe";
	}
	
	@PostMapping("/{shoeId}")
	public String updateShoe(@PathVariable long shoeId, @ModelAttribute("shoe") Shoe shoe) {
		shoeSvc.updateShoe(shoeId, shoe);
		return "/shoe/shoe";
	}
	
	@GetMapping("/delete/{shoeId}")
	public String deleteShoe(@PathVariable long shoeId) {
		shoeSvc.deleteShoe(shoeSvc.getShoeById(shoeId));
		return "redirect:/admin/";
	}
	
	@GetMapping("/add")
	public String addShoeForm(Model model, HttpSession session) {
		//only the admin can add shoes
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin != null) {
			Shoe shoe = new Shoe();
			model.addAttribute("shoe", shoe);
			return "/shoe/add-shoe";
		}
		return "redirect:/admin/";
	}
	
	@PostMapping("/add")
	public String addShoe(@ModelAttribute("shoe")Shoe shoe, HttpSession session) {
		//make sure only the admin adds shoes
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin != null) {
			shoeSvc.addShoe(shoe);
		}
		return "redirect:/admin/";
	}
	
	
	
}
