package com.tcs.springbootemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springbootemployee.model.Department;
import com.tcs.springbootemployee.model.Employee;
import com.tcs.springbootemployee.repository.OrganizationRepository;
import com.tcs.springbootemployee.model.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	

	@Autowired
	OrganizationRepository organizationRepository;



	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Organization organization2 = null;
		try {
			organization2 = organizationRepository.save(organization);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrganization(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Organization> findById(long id) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
