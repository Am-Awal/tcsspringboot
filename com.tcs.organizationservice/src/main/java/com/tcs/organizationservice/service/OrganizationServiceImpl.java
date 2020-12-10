package com.tcs.organizationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tcs.organizationservice.model.Department;
//import com.tcs.organizationservice.model.Employee;
import com.tcs.organizationservice.repository.OrganizationRepository;
import com.tcs.organizationservice.model.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	

	@Autowired
	OrganizationRepository organizationRepository;



	@Override
	public Organization addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Organization organization2 = null;
		try {
			organization2 = organizationRepository.save(organization);
			return organization2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteOrganization(long id) {
		// TODO Auto-generated method stub
		organizationRepository.deleteById(id);;
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(id);
	}

	@Override
	public Optional<Organization> getOrganizationById(long organizationId) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(organizationId);
	}

	/*@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(productRepository.findAll());
	}
	*/

	/*@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
