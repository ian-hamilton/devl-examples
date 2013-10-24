package com.inertia.solutions.spring.aop.interaction.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.aop.calculator.Calculator;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCalculatorInteractionImplTest {

	@Mock
	Calculator calculator;
	
	@InjectMocks
	ConsoleCalculatorInteractionImpl underTest;
	
	private ArgumentCaptor<Integer> argumentValue1 = ArgumentCaptor.forClass(Integer.class);
	private ArgumentCaptor<Integer> argumentValue2 = ArgumentCaptor.forClass(Integer.class);
	
	private static String TEST_INPUT_ADD = "10+5";
	private static String TEST_INPUT_SUBTRACT = "10-5";
	private static String TEST_INPUT_MULTIPLY = "10*5";
	private static String TEST_INPUT_DIVIDE = "10/5";
	private static String TEST_INPUT_ERROR = "5";
	
	private static String VALID_RESPONSE = "Calculation result = 1";
	
	@Before
	public void setup() {
		
		Mockito.when(calculator.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new Integer(1));
		Mockito.when(calculator.subtract(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new Integer(1));
		Mockito.when(calculator.multiply(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new Integer(1));
		Mockito.when(calculator.divide(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new Integer(1));
	}
	
	@Test
	public void testInteractWithCalculator_AddResult() throws Exception {
		String result = underTest.interactWithCalculator(TEST_INPUT_ADD);
		
		assertEquals(VALID_RESPONSE, result);
		Mockito.verify(calculator).add(argumentValue1.capture(), argumentValue2.capture());
		assertEquals(new Integer(10), argumentValue1.getValue());
		assertEquals(new Integer(5), argumentValue2.getValue());
	}
	
	@Test
	public void testInteractWithCalculator_SubtractResult() throws Exception {
		String result = underTest.interactWithCalculator(TEST_INPUT_SUBTRACT);
		
		assertEquals(VALID_RESPONSE, result);
		Mockito.verify(calculator).subtract(argumentValue1.capture(), argumentValue2.capture());
		assertEquals(new Integer(10), argumentValue1.getValue());
		assertEquals(new Integer(5), argumentValue2.getValue());
	}
	
	@Test
	public void testInteractWithCalculator_MultiplyResult() throws Exception {
		String result = underTest.interactWithCalculator(TEST_INPUT_MULTIPLY);
		assertEquals(VALID_RESPONSE, result);
		Mockito.verify(calculator).multiply(argumentValue1.capture(), argumentValue2.capture());
		assertEquals(new Integer(10), argumentValue1.getValue());
		assertEquals(new Integer(5), argumentValue2.getValue());
	}
	
	@Test
	public void testInteractWithCalculator_DivideResult() throws Exception {
		String result = underTest.interactWithCalculator(TEST_INPUT_DIVIDE);
		
		assertEquals(VALID_RESPONSE, result);
		Mockito.verify(calculator).divide(argumentValue1.capture(), argumentValue2.capture());
		assertEquals(new Integer(10), argumentValue1.getValue());
		assertEquals(new Integer(5), argumentValue2.getValue());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInteractWithCalculator_Error() throws Exception {
		underTest.interactWithCalculator(TEST_INPUT_ERROR);
	}

}
