package com.tcs.springbootauth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.springbootauth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByEmail(String email);
	List<User> findByUserName(String userName);
	Optional<User> findByFirstName(String firstName);
	Boolean existsByEmail(String email);
	Boolean existsByUserName(String userName);
	

}
