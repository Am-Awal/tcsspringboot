package com.tcs.springbootemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springbootemployee.repository.EmployeeRepository;
import com.tcs.springbootemployee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}

	@Override
	public String updateEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
