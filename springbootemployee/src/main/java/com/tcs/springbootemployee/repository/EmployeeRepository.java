package com.tcs.springbootemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.tcs.springbootemployee.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Optional<Employee> findById(String empId);
	Boolean existsById(long Id);

}
