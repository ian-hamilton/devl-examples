package com.inertia.solutions.spring.rest.app.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.spring.rest.app.bean.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryImplTest {
	
	private static final Integer ID = new Integer(101);
	
	Map<Integer, Employee> mockDb = new HashMap<Integer, Employee>();
	
	EmployeeRepositoryImpl repoUnderTest = new EmployeeRepositoryImpl();
	
	Employee employee;
	
	@Before
	public void setup() {
		employee = new Employee();
		employee.setEmployeeId(ID);
		employee.setFirstName("Ian");
		employee.setLastName("Hamilton");
		employee.setSocialSecurity("123-45-6789");
		employee.setTitle("King");
		this.mockDb.put(employee.getEmployeeId(), employee);

		repoUnderTest.setEmployeeMemoryDatabase(mockDb);
	}

	@Test
	public void testFindAll() throws Exception {
		Collection<Employee> result = repoUnderTest.findAll();
		assertEquals(1, result.size());
		assertSame(this.employee, result.toArray()[0]);
	}

	@Test
	public void testFind() throws Exception {
		Employee result = repoUnderTest.find(ID);
		assertSame(this.employee, result);
	}

	@Test
	public void testSave() throws Exception {
		Employee result = repoUnderTest.save(this.employee);
		assertSame(this.employee, result);
	}

	@Test
	public void testDelete() throws Exception {
		repoUnderTest.delete(ID);
		assertEquals(0, mockDb.size());
	}

	@Test
	public void testGenerateId() throws Exception {
		Integer result = repoUnderTest.generateId();
		assertTrue(result < new Integer(9999));
		assertTrue(result > new Integer(1000));
	}

}
