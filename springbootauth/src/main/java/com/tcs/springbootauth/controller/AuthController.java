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
@RequestMapping(path="/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login.html")
	public ModelAndView validateLogin(@ModelAttribute @Valid User user, BindingResult result) {
		System.out.println("hello from validatelogin " +user);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		if(user.equals(
				userRepository.findByEmail(user.getUserName()).get(0)
						)) {
			System.out.println("success");
			modelAndView.setViewName("guest");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("login");
		}
		//modelAndView.setViewName("redirect:/dashboard");
		//modelAndView.setViewName("guest");

		return modelAndView;
	}

}
