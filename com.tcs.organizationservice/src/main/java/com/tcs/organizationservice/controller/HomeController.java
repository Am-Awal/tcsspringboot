package com.tcs.organizationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//@GetMapping("/") // both mappings are equivalent, but use the one below
	@RequestMapping(path = {"/"}, method = RequestMethod.GET)
	public String getHomePage() {
		// TODO Auto-generated method stub
		return "home";

	}
	@GetMapping("/guest")
	public String getGuestHandler(@RequestAttribute("fname") String fname, Model model) {
		
		model.addAttribute("mname","a");
		return "guest";
		
	}
	
	@GetMapping("/admin")
	public String getAdminHandler(@RequestAttribute("fname") String fname, Model model) {
		
		model.addAttribute("mname","admin");
		return "admin";
		
	}
	

}
