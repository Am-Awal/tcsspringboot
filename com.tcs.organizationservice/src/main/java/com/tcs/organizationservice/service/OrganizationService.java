package com.tcs.organizationservice.service;

import java.util.List;
import java.util.Optional;

//import com.tcs.organizationservice.model.Department;
//import com.tcs.organizationservice.model.Employee;
import com.tcs.organizationservice.model.Organization;

public interface OrganizationService {
	

	public Organization addOrganization(Organization organization);
	public void deleteOrganization(long id);
	public Optional<Organization> findById(long id);
	//public Optional<List<Employee>> getEmployees();
	//public Optional<List<Department>> getDepartments();
	public Optional<Organization> getOrganizationById(long organizationId);


}
