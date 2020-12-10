package com.tcs.employeeservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.employeeservice.model.Employee;
import com.tcs.employeeservice.repository.EmployeeRepository;

public class CRUDController {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/findemployeebyid.html")
	public ModelAndView 
	findEmployeeById(@ModelAttribute @Valid	Employee employee, BindingResult result) {
		System.out.println("hello from findbyid " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("findemployeebyid");
			return modelAndView;
		}
		
		if( employeeRepository.existsById( employee.getId() ) ) {
			System.out.println("Employee exists");
			
			Optional<Employee> found = employeeRepository.findById(employee.getId());
			//String depts = "No departments set";
			//String emps = "No employees set";
			
			
			modelAndView.addObject("name", found.get().getName());
			modelAndView.addObject("id", found.get().getId());
			//modelAndView.addObject("address", found.get().getAddress());

			
			modelAndView.setViewName("employeefound");
		}else {
			System.out.println("Employee id not found");
			modelAndView.setViewName("findemployeebyid");
		}
		return modelAndView;
	}
	
	@PostMapping("/addemployee.html")
	public ModelAndView 
	addEmployee(@ModelAttribute @Valid	Employee employee, BindingResult result) {
		System.out.println("hello from add employee " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("addemployee");
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
	
	@PostMapping("/deleteemployee.html")
	public ModelAndView deleteEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
		System.out.println("hello from delete employee " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("deleteemployee");
			return modelAndView;
		}
		
		if(employeeRepository.existsById( employee.getId())) {
			System.out.println("Employee Exists");
			long employeeId = employee.getId();
			
			modelAndView.addObject("id", employeeId);
			employeeRepository.deleteById(employee.getId());
			System.out.println("Employee Deleted");
			
			modelAndView.setViewName("employeedeleted");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("deleteemployee");
		}

		return modelAndView;
	}

	
	@PostMapping("/updateemployee.html")
	public ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
		System.out.println("hello from update employee " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("updateemployee");
			return modelAndView;
		}
		
		if(employeeRepository.existsById( employee.getId())) {
			System.out.println("Employee Exists");
			employeeRepository.save(employee);
			modelAndView.setViewName("guest");
		}else {
			System.out.println("fail");
			modelAndView.setViewName("updateemployee");
		}


		return modelAndView;
	}

}
