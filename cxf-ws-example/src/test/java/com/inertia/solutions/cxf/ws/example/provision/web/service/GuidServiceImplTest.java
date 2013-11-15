package com.inertia.solutions.cxf.ws.example.provision.web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.inertia.solutions.cxf.ws.example.provision.beans.GuidBean;
import com.inertia.solutions.cxf.ws.example.provision.beans.NameBean;


public class GuidServiceImplTest {

	private static final String LAST_NAME = "Hamilton";
	private static final String FIRST_NAME = "Ian";

	Map<String, GuidBean> guidMap;
	
	GuidServiceImpl serviceUnderTest;
	
	@Before
	public void setup() {
		serviceUnderTest = new GuidServiceImpl();
		guidMap = new HashMap<String, GuidBean>();
		
		GuidBean bean = new GuidBean();
		bean.setFirstName(FIRST_NAME);
		bean.setLastName(LAST_NAME);
		bean.setGuid("123");
		guidMap.put(bean.toString(), bean);
		serviceUnderTest.setGuidMap(guidMap);
	}
	
	@Test
	public void shouldReturTrueDuplicate() throws Exception {
		NameBean name = new NameBean();
		name.setFirstName(FIRST_NAME);
		name.setLastName(LAST_NAME);
		Boolean result = serviceUnderTest.checkForDuplicate(name);
		assertTrue(result);
	}
	
	@Test
	public void shouldReturFalseDuplicate() throws Exception {
		NameBean name = new NameBean();
		name.setFirstName("Sam");
		name.setLastName("Iam");
		Boolean result = serviceUnderTest.checkForDuplicate(name);
		assertFalse(result);
	}

	@Test
	public void testGetGuid() throws Exception {
		NameBean name = new NameBean();
		name.setFirstName(FIRST_NAME);
		name.setLastName(LAST_NAME);
		String result = serviceUnderTest.getGuid(name);
		assertNotNull(result);
	}

}
