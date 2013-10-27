package com.inertia.solutions.spring.mvc.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.mvc.app.bean.Employee;
import com.inertia.solutions.spring.mvc.app.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest {

	private static final Integer ID = new Integer(101);
	private static final Integer GENERATED_ID = new Integer(1001);

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeRestController controllerUnderTest;
	
	Employee employee;
	
	@Before
	public void setup() {		
		employee = new Employee();
		employee.setEmployeeId(ID);
		employee.setFirstName("Ian");
		employee.setLastName("Hamilton");
		employee.setSocialSecurity("123-45-6789");
		employee.setTitle("King");
		
		Mockito.when(employeeRepository.findAll()).thenReturn(new ArrayList<Employee>(Arrays.asList(employee)));
		Mockito.when(employeeRepository.find(ID)).thenReturn(employee);
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		Mockito.when(employeeRepository.generateId()).thenReturn(GENERATED_ID);
	}
	
	@Test
	public void testGetAll() throws Exception {
		Collection<Employee> result = controllerUnderTest.getAll();
		assertEquals(1, result.size());
		assertSame(this.employee, new ArrayList<Employee>(result).get(0));
	}

	@Test
	public void testGet() throws Exception {
		Employee result = controllerUnderTest.get(ID);
		Mockito.verify(employeeRepository).find(ID);
		assertSame(this.employee, result);
	}

	@Test
	public void testPut() throws Exception {
		ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
		Employee result = controllerUnderTest.put(this.employee);
		
		Mockito.verify(employeeRepository).save(captor.capture());
		assertEquals(GENERATED_ID, captor.getValue().getEmployeeId());
		assertSame(captor.getValue(), result);
	}

	@Test
	public void testPost() throws Exception {
		Employee result = controllerUnderTest.post(ID, employee);
		assertSame(this.employee, result);
	}

	@Test
	public void testDelete() throws Exception {
		controllerUnderTest.delete(ID);
		Mockito.verify(employeeRepository).delete(ID);
	}

	@Test
	public void testHead() throws Exception {
		String result = controllerUnderTest.head();
		assertEquals("", result);
	}

	@Test
	public void testHandleException() throws Exception {
		String result = controllerUnderTest.handleException(new RuntimeException("test exception"));
		assertNull(result);
	}

}
