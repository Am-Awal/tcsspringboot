package com.tcs.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeeservice.repository.EmployeeRepository;
import com.tcs.employeeservice.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee2 = null;
		try {
			employee2 = employeeRepository.save(employee);
			return employee2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);;
	}


	
	@Override
	public Optional<Employee> getEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId);
	}

}
