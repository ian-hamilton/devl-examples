/**
 * 
 */
package com.inertia.solutions.cxf.ws.example.provision.web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.inertia.solutions.cxf.ws.example.provision.beans.NameBean;

/**
 * The Interface GuidService.
 *
 * @author ian
 */
@WebService
public interface GuidService {

	/**
	 * Check for duplicate.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @return the boolean
	 */
	@WebMethod(action="checkForDuplicate")
	public Boolean checkForDuplicate(NameBean name);
	
	/**
	 * Gets the guid.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @return the guid
	 */
	public String getGuid(NameBean name);
}
