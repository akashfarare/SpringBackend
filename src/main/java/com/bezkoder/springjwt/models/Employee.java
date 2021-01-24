package com.bezkoder.springjwt.models;

import javax.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(	name = "employeedata")
public class Employee {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private Long empid;
	
	@Size(max = 20)
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
