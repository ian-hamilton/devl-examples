package com.inertia.solutions.spring.orm.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;


public class ShoppingCartTest {

	private static final String USER_NAME = "userName";
	private static final Float TOTAL = new Float(999.99);
	private static final HashSet<ShoppingCartItem> SHOPPING_CART_ITEMS = new HashSet<ShoppingCartItem>();
	private static final Long SHOPPING_CART_ID = new Long(101);
	
	ShoppingCart underTest = new ShoppingCart();
	
	@Before
	public void setup() {
		underTest.setShoppingCartId(SHOPPING_CART_ID);
		underTest.setShoppingCartItems(SHOPPING_CART_ITEMS);
		underTest.setTotal(TOTAL);
		underTest.setUserName(USER_NAME);
	}
	
	@Test
	public void testGetters() {
		assertEquals(SHOPPING_CART_ID, underTest.getShoppingCartId());
		assertEquals(TOTAL, underTest.getTotal());
		assertEquals(USER_NAME, underTest.getUserName());
		assertSame(SHOPPING_CART_ITEMS, underTest.getShoppingCartItems());
	}
}
