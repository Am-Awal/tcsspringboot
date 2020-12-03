package com.tcs.springbootemployee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.springbootemployee.model.Employee;
import com.tcs.springbootemployee.repository.DepartmentRepository;
import com.tcs.springbootemployee.repository.EmployeeRepository;
import com.tcs.springbootemployee.repository.OrganizationRepository;

@Controller
@RequestMapping(path="/register")
public class RegistrationController {

	@Autowired
	EmployeeRepository employeeRepository;
	OrganizationRepository  orgRep;
	DepartmentRepository deptRepo;
	@GetMapping("/addemployee.html")
	public String getLoginPage() {
		return "registration";
	}
	
	@PostMapping("/addemployee.html")
	public ModelAndView registerUser(@ModelAttribute @Valid Employee employee, BindingResult result) {
		System.out.println("hello from registration " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("registration");
			return modelAndView;
		}
		
		if(employeeRepository.findById(employee.getId()).isEmpty()) {
			employeeRepository.save(employee);
			modelAndView.setViewName("registrationSuccess");
			System.out.println("success");
		}else {
			System.out.println("employee already exists");
			modelAndView.setViewName("registration");
		}
		

		return modelAndView;
	}

	
}
