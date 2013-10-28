/**
 * 
 */
package com.inertia.solutions.cxf.ws.example.provision.beans;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Using JRE 1.7.0_07
 * 
 * The Class GuidBean.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 */
public class GuidBean extends NameBean implements Serializable{

	/* (non-Javadoc)
	 * @see com.intertia.cxf.provision.beans.NameBean#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4363223912662805790L;

	/** The guid. */
	private String guid;

	/**
	 * Gets the guid.
	 *
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * Sets the guid.
	 *
	 * @param guid the new guid
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
}
