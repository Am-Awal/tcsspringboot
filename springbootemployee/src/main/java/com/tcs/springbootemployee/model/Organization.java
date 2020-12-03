package com.tcs.springbootemployee.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "organization_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
	
	@Id
	@Column(name = "org_id")
	private long id;
	@Column(name = "org_name")
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "organization" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Department> departments = new ArrayList<>();
	
	@OneToMany(mappedBy = "organization" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Employee> employees = new ArrayList<>();

}
