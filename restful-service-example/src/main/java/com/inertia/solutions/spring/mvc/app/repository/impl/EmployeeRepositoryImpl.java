package com.inertia.solutions.spring.mvc.app.repository.impl;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inertia.solutions.spring.mvc.app.bean.Employee;
import com.inertia.solutions.spring.mvc.app.repository.EmployeeRepository;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	
	@Autowired
	Map<Integer, Employee> employeeMemoryDatabase;
	
	@Override
	public Collection<Employee> findAll() {
		return this.employeeMemoryDatabase.values();
	}

	@Override
	public Employee find(Integer id) {
		if(this.employeeMemoryDatabase.containsKey(id))
			return this.employeeMemoryDatabase.get(id);
		else
			return null;
	}

	@Override
	public Employee save(Employee obj) {
		this.employeeMemoryDatabase.put(obj.getEmployeeId(), obj);
		return obj;
	}

	@Override
	public Boolean delete(Integer id) {
		Boolean found = false;
		if(this.employeeMemoryDatabase.containsKey(id)) {
			found = true;
			this.employeeMemoryDatabase.remove(id);
		}
		return found;
	}

}
