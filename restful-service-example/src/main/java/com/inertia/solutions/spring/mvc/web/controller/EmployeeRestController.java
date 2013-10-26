package com.inertia.solutions.spring.mvc.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inertia.solutions.spring.mvc.app.bean.Employee;
import com.inertia.solutions.spring.mvc.app.repository.EmployeeRepository;


@Controller
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeRepository employeeRepository;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody Collection<Employee> getAll() {
		return this.employeeRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee get(@PathVariable Integer id) {
		return this.employeeRepository.find(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody Employee put(@RequestBody Employee employee) {
		Integer id = new Integer(102);
		employee.setEmployeeId(id);
		this.employeeRepository.save(employee);
		return this.employeeRepository.find(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody Employee post(@PathVariable Integer id, @RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		this.employeeRepository.delete(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.HEAD)
	public String head() {
		return "";
	}
}
