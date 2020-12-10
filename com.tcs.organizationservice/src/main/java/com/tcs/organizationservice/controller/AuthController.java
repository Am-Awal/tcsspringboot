package com.tcs.organizationservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.tcs.organizationservice.model.Employee;
import com.tcs.organizationservice.model.Organization;
//import com.tcs.organizationservice.repository.EmployeeRepository;
import com.tcs.organizationservice.repository.OrganizationRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {
	
	//@Autowired
	//EmployeeRepository employeeRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@GetMapping("/findbyid.html")
	public String getFindByIdPage() {
		return "findbyid";
	}
	
	@PostMapping("/findorganizationbyid.html")
	public ModelAndView 
	findOrganizationById(@ModelAttribute @Valid Organization organization, BindingResult result) {
		System.out.println("hello from findbyid " +organization);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("findorganizationbyid");
			return modelAndView;
		}
		
		if( organizationRepository.existsById( organization.getId() ) ) {
			System.out.println("Organization exists");
			
			Optional<Organization> found = organizationRepository.findById(organization.getId());
			//String depts = "No departments set";
			//String emps = "No employees set";
			
			
			modelAndView.addObject("name", found.get().getName());
			modelAndView.addObject("id", found.get().getId());
			modelAndView.addObject("address", found.get().getAddress());

			
			modelAndView.setViewName("organizationfound");
		}else {
			System.out.println("Organization id not found");
			modelAndView.setViewName("findorganizationbyid");
		}
		return modelAndView;
	}
}
