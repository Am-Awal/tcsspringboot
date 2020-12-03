package com.tcs.springbootauth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_tbl")
public class User {

	 @Id
	 
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	     private Long id;
	 
	     private String firstName;
	 
	    private String lastName;
	 
	     private String mobile;
	 
	     private String email;
	     private String userName;
	     private String password;
	     
	     //one user can have many roles
	     @ManyToMany
	     @JoinTable(name ="user_roles",joinColumns = @JoinColumn(name = "user_id"),
	     inverseJoinColumns = @JoinColumn(name = "role_id"))
	     private Set<Role> roles = new HashSet<>();
	     
	     
	     
	     
	     
}
