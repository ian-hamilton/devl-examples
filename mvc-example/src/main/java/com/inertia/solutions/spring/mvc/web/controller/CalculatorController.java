package com.inertia.solutions.spring.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Calulator")
public class CalculatorController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "calculator";
	}
	
}
