package com.tcs.springbootemployee.controller;

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

import com.tcs.springbootemployee.model.Employee;
import com.tcs.springbootemployee.repository.EmployeeRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping("/findbyid.html")
	public String getFindByIdPage() {
		return "findbyid";
	}
	
	@PostMapping("/findbyid.html")
	public ModelAndView validateLogin(@ModelAttribute @Valid Employee employee, BindingResult result) {
		System.out.println("hello from findbyid " +employee);
		
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage()+ " "+e.getField());});
					
			modelAndView.setViewName("findbyid");
			return modelAndView;
		}
		
		if( employeeRepository.existsById( employee.getId() ) ) {
			System.out.println("Employee exists");
			
			Optional<Employee> found = employeeRepository.findById(employee.getId());
			String dept = "No department set";
			String org = "No organization set";
			
			//new Employee(3, org1, dep1, "Emp one", 23, "Analyst");
			modelAndView.addObject("name", found.get().getName());
			modelAndView.addObject("id", found.get().getId());
			modelAndView.addObject("age", found.get().getAge());
			modelAndView.addObject("position", found.get().getPosition());
			
			if(found.get().getOrganization()==null) {
				modelAndView.addObject("organization", org);
			}else modelAndView.addObject("organization", found.get().getOrganization());
			
			if(found.get().getDepartment()==null) {
				modelAndView.addObject("department", dept);
			} else modelAndView.addObject("department", found.get().getDepartment());
			
			
			modelAndView.setViewName("employeefound");
		}else {
			System.out.println("Employee id not found");
			modelAndView.setViewName("findbyid");
		}


		return modelAndView;
	}

	
	@PostMapping("/updateemployee.html")
	public ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
		System.out.println("hello from validatelogin " +employee);
		
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
