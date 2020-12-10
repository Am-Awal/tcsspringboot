package com.tcs.organizationservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.organizationservice.model.Organization;
import com.tcs.organizationservice.repository.OrganizationRepository;

public class CRUDController {
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@PostMapping("/findorganizationbyid.html")
	public ModelAndView 
	findOrganizationById(@ModelAttribute @Valid	Organization organization, BindingResult result) {
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
	
	@PostMapping("/addorganization.html")
	public ModelAndView 
	addOrganization(@ModelAttribute @Valid	Organization organization, BindingResult result) {
		System.out.println("hello from add organization " +organization);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("addorganization");
			return modelAndView;
		}
		
		if(organizationRepository.findById(organization.getId()).isEmpty()) {
			organizationRepository.save(organization);
			modelAndView.setViewName("registrationSuccess");
			System.out.println("success");
		}else {
			System.out.println("organization already exists");
			modelAndView.setViewName("registration");
		}
	
		return modelAndView;
	}
	
	@PostMapping("/deleteorganization.html")
	public ModelAndView deleteOrganization(@ModelAttribute @Valid Organization organization, BindingResult result) {
		System.out.println("hello from delete organization " +organization);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("deleteorganization");
			return modelAndView;
		}
		
		if(organizationRepository.existsById( organization.getId())) {
			System.out.println("Organization Exists");
			long organizationId = organization.getId();
			
			modelAndView.addObject("id", organizationId);
			organizationRepository.deleteById(organization.getId());
			System.out.println("Organization Deleted");
			
			modelAndView.setViewName("organizationdeleted");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("deleteorganization");
		}

		return modelAndView;
	}

	
	@PostMapping("/updateorganization.html")
	public ModelAndView updateOrganization(@ModelAttribute @Valid Organization organization, BindingResult result) {
		System.out.println("hello from update organization " +organization);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("updateorganization");
			return modelAndView;
		}
		
		if(organizationRepository.existsById( organization.getId())) {
			System.out.println("Organization Exists");
			organizationRepository.save(organization);
			modelAndView.setViewName("guest");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("updateorganization");
		}


		return modelAndView;
	}




}
