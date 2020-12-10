package com.tcs.employeeservice.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeeservice.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public void deleteEmployee(long id);
	//public Optional<Employee> findById(long id);
	//public Optional<List<Employee>> getEmployees();
	public Optional<Employee> getEmployeeById(long employeeId);

}
