package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Shoe;
import com.app.model.ShoeCategory;
import com.app.service.ShoeService;

@Controller
@RequestMapping("/")
public class SportyShoesController {
	
	@Autowired
	ShoeService shoeSvc;
	
	@RequestMapping("/")
	public String homepage(Model model) {
		model.addAttribute("homeMessage", "This is the Sporty Shoes Homepage Message!!!");
		
		List<Shoe> shoes = new ArrayList<Shoe>();
		shoeSvc.getAllShoes().forEach(shoes::add);
		
		model.addAttribute("shoes",shoes);
		
		return "index";
	}
	
	@GetMapping("/populateShoes")
	public String populateShoes() {
		
		shoeSvc.addShoe(new Shoe("The Running Shoe", 55.00, ShoeCategory.RUNNING));
		shoeSvc.addShoe(new Shoe("The Tennis Shoe", 65.00, ShoeCategory.TENNIS));
		shoeSvc.addShoe(new Shoe("The Boots", 80.00, ShoeCategory.BOOTS));
		
		return "index";
	}
	
	

}
