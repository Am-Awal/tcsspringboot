package com.tcs.departmentservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.departmentservice.model.Department;
import com.tcs.departmentservice.repository.DepartmentRepository;

public class CRUDController {
	
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping("/finddepartmentbyid.html")
	public ModelAndView 
	findDepartmentById(@ModelAttribute @Valid	Department department, BindingResult result) {
		System.out.println("hello from findbyid " +department);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("finddepartmentbyid");
			return modelAndView;
		}
		
		if( departmentRepository.existsById( department.getId() ) ) {
			System.out.println("Department exists");
			
			Optional<Department> found = departmentRepository.findById(department.getId());
			//String depts = "No departments set";
			//String emps = "No employees set";
			
			
			modelAndView.addObject("name", found.get().getName());
			modelAndView.addObject("id", found.get().getId());
			//modelAndView.addObject("address", found.get().getAddress());

			
			modelAndView.setViewName("departmentfound");
		}else {
			System.out.println("Department id not found");
			modelAndView.setViewName("finddepartmentbyid");
		}
		return modelAndView;
	}
	
	@PostMapping("/adddepartment.html")
	public ModelAndView 
	addDepartment(@ModelAttribute @Valid	Department department, BindingResult result) {
		System.out.println("hello from add department " +department);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("adddepartment");
			return modelAndView;
		}
		
		if(departmentRepository.findById(department.getId()).isEmpty()) {
			departmentRepository.save(department);
			modelAndView.setViewName("registrationSuccess");
			System.out.println("success");
		}else {
			System.out.println("department already exists");
			modelAndView.setViewName("registration");
		}
	
		return modelAndView;
	}
	
	@PostMapping("/deletedepartment.html")
	public ModelAndView deleteDepartment(@ModelAttribute @Valid Department department, BindingResult result) {
		System.out.println("hello from delete department " +department);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("deletedepartment");
			return modelAndView;
		}
		
		if(departmentRepository.existsById( department.getId())) {
			System.out.println("Department Exists");
			long departmentId = department.getId();
			
			modelAndView.addObject("id", departmentId);
			departmentRepository.deleteById(department.getId());
			System.out.println("Department Deleted");
			
			modelAndView.setViewName("departmentdeleted");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("deletedepartment");
		}

		return modelAndView;
	}

	
	@PostMapping("/updatedepartment.html")
	public ModelAndView updateDepartment(@ModelAttribute @Valid Department department, BindingResult result) {
		System.out.println("hello from update department " +department);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("updatedepartment");
			return modelAndView;
		}
		
		if(departmentRepository.existsById( department.getId())) {
			System.out.println("Department Exists");
			departmentRepository.save(department);
			modelAndView.setViewName("guest");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("updatedepartment");
		}


		return modelAndView;
	}

}
