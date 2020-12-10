package com.tcs.departmentservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.departmentservice.exception.ResourceNotFoundException;
import com.tcs.departmentservice.model.Department;
import com.tcs.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
	@Autowired
	com.tcs.departmentservice.service.DepartmentService departmentService;
	
	
	/*@GetMapping
	public List<Department> getDepartments() {
		return departmentService.getDepartments().get();
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> 
	getDepartmentById(@PathVariable("id") long departmentId) throws ResourceNotFoundException {
		
		Department department = departmentService.getDepartmentById(departmentId).orElseThrow(()-> 
			new ResourceNotFoundException("Department not found"));
		
		return ResponseEntity.ok().body(department);
	}
	
	@PostMapping
	public ResponseEntity<?> 
	createDepartment
	(@RequestBody Department department, UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
		
		Department department2 = departmentService.addDepartment(department);
		UriComponents uriComponents = 
				uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(department2.getId());
			
	  return ResponseEntity.created(uriComponents.toUri()).body(department2);
	}
	
	@DeleteMapping("/{id}")

	public Map<String, Boolean> deleteDepartmentById(@PathVariable int id) throws ResourceNotFoundException { 
		Department department =
				departmentService.getDepartmentById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Department not found"));
		
		departmentService.deleteDepartment(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		return hashMap;
	}
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") Integer id, 
			@Valid @RequestBody Department department) throws ResourceNotFoundException{
		
		Department department2 =
				departmentService.getDepartmentById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Department not found"));
		
		department.setId(id);
		Department department3 = departmentService.addDepartment(department);
		
		return ResponseEntity.ok(department3);
	}
	
}
