/**
 * 
 */
package com.inertia.solutions.spring.mvc.app.bean;

import java.io.Serializable;


public class Employee implements Serializable{
	private static final long serialVersionUID = 4810122396994655807L;

	private Integer employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String title;
	
	private String socialSecurity;

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
}
