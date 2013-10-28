/**
 * 
 */
package com.inertia.solutions.cxf.ws.example.provision.beans;

import java.io.Serializable;

/**
 * Using JRE 1.7.0_07
 * 
 * The Class NameBean.
 *
 * @author ian
 */
public class NameBean implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3321700909162708593L;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder().append(this.firstName).append(this.lastName).toString();
	}

}
