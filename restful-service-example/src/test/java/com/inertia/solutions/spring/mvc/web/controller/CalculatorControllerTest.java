package com.inertia.solutions.spring.mvc.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.inertia.solutions.spring.mvc.app.calculator.command.OperatorCommand;
import com.inertia.solutions.spring.mvc.app.calculator.command.impl.OperatorCommandInvoker;
import com.inertia.solutions.spring.mvc.web.model.CalculationModel;
import com.inertia.solutions.spring.mvc.web.model.OperatorModel;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {
	
	@Mock
	OperatorCommandInvoker operatorCommandInvoker;
	
	@Mock
	OperatorCommand operatorCommand;
	
	@InjectMocks
	CalculatorController controllerUnderTest;
	
	@Mock
	Model model;
	
	CalculationModel calculationModel;
	
	private final Integer value1 = new Integer(5);
	private final Integer value2 = new Integer(6);
	private final Integer result = new Integer(1);
	private static final String ADD = "+";
	
	@Before
	public void setup() {
		Mockito.when(operatorCommandInvoker.invoke(ADD)).thenReturn(operatorCommand);
		Mockito.when(operatorCommand.exec(value1, value2)).thenReturn(result);
		
		calculationModel = new CalculationModel();
		calculationModel.setOperator(ADD);
		calculationModel.setValue1(value1);
		calculationModel.setValue2(value2);
	}
	
	@Test
	public void testGet() throws Exception {
		String result = controllerUnderTest.get(calculationModel, model);
		assertEquals("calculator", result);
	}

	@Test
	public void testPost() throws Exception {
		String result = controllerUnderTest.post(calculationModel, model);
		assertEquals("calculator", result);
		Mockito.verify(operatorCommandInvoker).invoke(ADD);
		Mockito.verify(operatorCommand).exec(value1, value2);
		Mockito.verify(model).addAttribute("result", this.result);
	}

	@Test
	public void testProcessSubmit() throws Exception {
		controllerUnderTest.processSubmit(calculationModel, model);
		Mockito.verify(model).addAttribute(Mockito.isA(OperatorModel.class));
	}

	@Test
	public void testProcessSubmit_New() throws Exception {
		controllerUnderTest.processSubmit(null, model);
		Mockito.verify(model).addAttribute(Mockito.isA(CalculationModel.class));
		Mockito.verify(model).addAttribute(Mockito.isA(OperatorModel.class));
	}
	

}
