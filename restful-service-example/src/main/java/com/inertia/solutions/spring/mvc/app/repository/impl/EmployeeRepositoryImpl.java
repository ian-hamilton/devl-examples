package com.inertia.solutions.spring.mvc.app.repository.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.inertia.solutions.spring.mvc.app.bean.Employee;
import com.inertia.solutions.spring.mvc.app.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Resource(name="employeeMemoryDatabase")
	Map<Integer, Employee> employeeMemoryDatabase;
	
	@Override
	public Collection<Employee> findAll() {
		return employeeMemoryDatabase.values();
	}

	@Override
	public Employee find(Integer id) {
		if(employeeMemoryDatabase.containsKey(id))
			return employeeMemoryDatabase.get(id);
		else
			return null;
	}

	@Override
	public Employee save(Employee obj) {
		employeeMemoryDatabase.put(obj.getEmployeeId(), obj);
		return obj;
	}

	@Override
	public Boolean delete(Integer id) {
		Boolean found = false;
		if(employeeMemoryDatabase.containsKey(id)) {
			found = true;
			employeeMemoryDatabase.remove(id);
		}
		return found;
	}

	@Override
	public Integer generateId() {
		Integer Min = new Integer(1000);
		Integer Max = new Integer(9999);
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}

}
