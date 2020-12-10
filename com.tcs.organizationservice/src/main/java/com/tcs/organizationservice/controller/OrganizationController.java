package com.tcs.organizationservice.controller;

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

import com.tcs.organizationservice.exception.ResourceNotFoundException;
import com.tcs.organizationservice.model.Organization;
import com.tcs.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {
	@Autowired
	com.tcs.organizationservice.service.OrganizationService organizationService;
	
	
	/*@GetMapping
	public List<Organization> getOrganizations() {
		return organizationService.getOrganizations().get();
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Organization> 
	getOrganizationById(@PathVariable("id") long organizationId) throws ResourceNotFoundException {
		
		Organization organization = organizationService.getOrganizationById(organizationId).orElseThrow(()-> 
			new ResourceNotFoundException("Organization not found"));
		
		return ResponseEntity.ok().body(organization);
	}
	
	@PostMapping
	public ResponseEntity<?> 
	createOrganization
	(@RequestBody Organization organization, UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
		
		Organization organization2 = organizationService.addOrganization(organization);
		UriComponents uriComponents = 
				uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(organization2.getId());
			
	  return ResponseEntity.created(uriComponents.toUri()).body(organization2);
	}
	
	@DeleteMapping("/{id}")

	public Map<String, Boolean> deleteOrganizationById(@PathVariable int id) throws ResourceNotFoundException { 
		Organization organization =
				organizationService.getOrganizationById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Organization not found"));
		
		organizationService.deleteOrganization(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		return hashMap;
	}
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") Integer id, 
			@Valid @RequestBody Organization organization) throws ResourceNotFoundException{
		
		Organization organization2 =
				organizationService.getOrganizationById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Organization not found"));
		
		organization.setId(id);
		Organization organization3 = organizationService.addOrganization(organization);
		
		return ResponseEntity.ok(organization3);
	}
	
}
