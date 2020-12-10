package com.tcs.departmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.departmentservice.repository.DepartmentRepository;
//import com.tcs.employeeservice.model.Employee;
import com.tcs.departmentservice.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	

	@Override
	public Optional<Department> findById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	/*@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Optional<List<Department>> findByOrganizationId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Department department2 = null;
		try {
			department2 = departmentRepository.save(department);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String updateDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
