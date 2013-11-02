package com.inertia.solutions.spring.orm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.ShoppingCartItem;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartItemDaoImplTest {

	@Mock
	SessionFactory mockSessionFactory;
	
	@InjectMocks
	ShoppingCartItemDaoImpl daoUnderTest;
	
	@Mock
	Session mockSession;
	
	ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
	
	@Before
	public void setup() {
		Mockito.when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession);
	}

	@Test
	public void testSave() throws Exception {
		daoUnderTest.save(shoppingCartItem);
		Mockito.verify(mockSession).save(shoppingCartItem);
	}
	
	
}
