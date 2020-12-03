package com.tcs.springbootemployee.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	@Column(name = "dept_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")
	private Organization organization;
	@Column(name = "dept_name")
	private String name;
	
	@OneToMany(mappedBy = "department" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Employee> employees;

	public void setOrganization(Optional<Organization> myOrg) {
		// TODO Auto-generated method stub
		
	}
	
	

}
