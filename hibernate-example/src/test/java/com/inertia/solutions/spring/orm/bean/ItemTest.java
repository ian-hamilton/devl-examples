package com.inertia.solutions.spring.orm.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ItemTest {

	private static final Float ITEM_PRICE = new Float(10.1);
	private static final String ITEM_NAME = "itemName";
	private static final Long ITEM_ID = new Long(101);
	
	Item underTest = new Item();
	
	@Before
	public void setup() {
		underTest.setItemId(ITEM_ID);
		underTest.setItemName(ITEM_NAME);
		underTest.setItemPrice(ITEM_PRICE);
	}
	
	@Test
	public void testGetters() {
		assertEquals(ITEM_PRICE, underTest.getItemPrice());
		assertEquals(ITEM_NAME, underTest.getItemName());
		assertEquals(ITEM_ID, underTest.getItemId());
	}
}
