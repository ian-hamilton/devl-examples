package com.inertia.solutions.spring.mvc.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.inertia.solutions.spring.mvc.app.bean.Employee;
import com.inertia.solutions.spring.mvc.app.repository.EmployeeRepository;


@Controller
@RequestMapping("/employee")
public class EmployeeRestController {
	private static final Logger log = Logger.getLogger(EmployeeRestController.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee get(@PathVariable Integer id) {
		return employeeRepository.find(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Employee put(@RequestBody Employee employee) {
		Integer id = employeeRepository.generateId();
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
		return employeeRepository.find(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody Employee post(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		employeeRepository.delete(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.HEAD)
	public String head() {
		return "";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception ex) {
		log.error("Exception during controller handling", ex);
		return null;
	}
}
