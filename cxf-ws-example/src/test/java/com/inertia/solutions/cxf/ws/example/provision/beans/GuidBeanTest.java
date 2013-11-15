package com.inertia.solutions.cxf.ws.example.provision.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class GuidBeanTest {

	private static final String GUID = "guid";
	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";

	GuidBean underTest = new GuidBean();
	
	@Before
	public void setup() {
		underTest.setFirstName(FIRST_NAME);
		underTest.setLastName(LAST_NAME);
		underTest.setGuid(GUID);
	}
	
	@Test
	public void testGettersSetters() {
		assertEquals(GUID, underTest.getGuid());
		assertEquals(FIRST_NAME, underTest.getFirstName());
		assertEquals(LAST_NAME, underTest.getLastName());
	}
	
}
