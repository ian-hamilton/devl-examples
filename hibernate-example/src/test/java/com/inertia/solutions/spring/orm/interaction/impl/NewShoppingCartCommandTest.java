package com.inertia.solutions.spring.orm.interaction.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@RunWith(MockitoJUnitRunner.class)
public class NewShoppingCartCommandTest {

	private static final String INTERACTION = "\nPlease Enter User Name: ";
	
	private static final String INPUT = "Ian";
	
	@Mock
	ShoppingCartService shoppingCartService;
	
	NewShoppingCartCommand commandUnderTest;
	
	ShoppingCart shoppingCart;
	
	@Before
	public void setup() {
		commandUnderTest = new NewShoppingCartCommand(shoppingCartService);
		shoppingCart = new ShoppingCart();
		
		Mockito.when(shoppingCartService.startNewShoppingCart(INPUT)).thenReturn(shoppingCart);
	}

	@Test
	public void testGetInteraction() throws Exception {
		String result = commandUnderTest.getInteraction();
		assertEquals(INTERACTION, result);
	}

	@Test
	public void testExecute() throws Exception {
		String result = commandUnderTest.execute(INPUT);
		assertEquals(shoppingCart.toString(), result);
	}
}
