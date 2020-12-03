package com.tcs.springbootauth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.springbootauth.model.User;
import com.tcs.springbootauth.repository.UserRepository;

@Controller
@RequestMapping(path="/register")
public class RegistrationController {

	@Autowired
	UserRepository userRepository;
	@GetMapping("/registration.html")
	public String getLoginPage() {
		return "registration";
	}
	
	@PostMapping("/registration.html")
	public ModelAndView registerUser(@ModelAttribute @Valid User user, BindingResult result) {
		System.out.println("hello from registration " +user);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("registration");
			return modelAndView;
		}
		
		if(userRepository.findByEmail(user.getEmail()).isEmpty()) {
			userRepository.save(user);
			modelAndView.setViewName("registrationSuccess");
			System.out.println("success");
		}else {
			System.out.println("user already exists");
			modelAndView.setViewName("registrationFail");
		}
		

		return modelAndView;
	}

	
}
