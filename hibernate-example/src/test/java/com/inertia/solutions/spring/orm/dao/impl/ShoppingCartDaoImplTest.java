package com.inertia.solutions.spring.orm.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.SimpleExpression;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.orm.bean.ShoppingCart;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartDaoImplTest {

	private static final String USER = "User";

	@Mock
	SessionFactory mockSessionFactory;
	
	@InjectMocks
	ShoppingCartDaoImpl daoUnderTest;
	
	@Mock
	Criteria mockCriteria;
	
	@Mock
	Session mockSession;
	
	ShoppingCart shoppingCart = new ShoppingCart();
	
	@Before
	public void setup() {
		Mockito.when(mockSessionFactory.getCurrentSession()).thenReturn(mockSession);
		Mockito.when(mockSession.createCriteria(ShoppingCart.class)).thenReturn(mockCriteria);
		Mockito.when(mockCriteria.add(Matchers.isA(SimpleExpression.class))).thenReturn(mockCriteria);
		Mockito.when(mockCriteria.uniqueResult()).thenReturn(shoppingCart);
	}

	@Test
	public void testSave() throws Exception {
		daoUnderTest.save(shoppingCart);
		Mockito.verify(mockSession).save(shoppingCart);
	}

	@Test
	public void testFind() throws Exception {
		ArgumentCaptor<SimpleExpression> captor = ArgumentCaptor.forClass(SimpleExpression.class);
		ShoppingCart result = daoUnderTest.find(USER);
		Mockito.verify(mockCriteria).add(captor.capture());
		assertSame(shoppingCart, result);
		assertEquals("userName", captor.getValue().getPropertyName());
		assertEquals(USER, captor.getValue().getValue());
	}

	@Test
	public void testUpdate() throws Exception {
		daoUnderTest.update(shoppingCart);
		Mockito.verify(mockSession).update(shoppingCart);
	}
}
