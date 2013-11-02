package com.inertia.solutions.spring.orm.interaction.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.inertia.solutions.spring.orm.interaction.InteractionCommand;
import com.inertia.solutions.spring.orm.service.ShoppingCartService;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleShoppingCartInteractionInvokerImplTest {

	@Mock
	ShoppingCartService shoppingCartService;
	
	@InjectMocks
	ConsoleShoppingCartInteractionInvokerImpl invokerUnderTest;
	
	@Before
	public void setup() {
		invokerUnderTest.init();
	}

	@Test
	public void testInvoke_ListItemCommand() throws Exception {
		InteractionCommand result = invokerUnderTest.invoke(new Integer(1));
		Assert.isInstanceOf(ListItemCommand.class, result);
	}
	
	@Test
	public void testInvoke_NewShoppingCartCommand() throws Exception {
		InteractionCommand result = invokerUnderTest.invoke(new Integer(2));
		Assert.isInstanceOf(NewShoppingCartCommand.class, result);
	}
	
	@Test
	public void testInvoke_AddItemToCartCommand() throws Exception {
		InteractionCommand result = invokerUnderTest.invoke(new Integer(3));
		Assert.isInstanceOf(AddItemToCartCommand.class, result);
	}
	
}
