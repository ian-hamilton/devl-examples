package com.inertia.solutions.spring.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inertia.solutions.spring.mvc.app.calculator.command.impl.OperatorCommandInvoker;
import com.inertia.solutions.spring.mvc.web.model.CalculationModel;
import com.inertia.solutions.spring.mvc.web.model.OperatorModel;

/*
 * http://localhost:8080/mvc-example/calculator
 */

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	OperatorCommandInvoker operatorCommandInvoker;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute CalculationModel calculationModel, Model model) {
		return "calculator";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute CalculationModel calculationModel, Model model) {
		Integer result = operatorCommandInvoker.invoke(calculationModel.getOperator())
				.exec(calculationModel.getValue1(), calculationModel.getValue2());
		model.addAttribute("result", result);
		return "calculator";
	}
	
	@ModelAttribute
	public void processSubmit(@ModelAttribute CalculationModel calculationModel, Model model) {
		if(calculationModel == null)
			model.addAttribute(new CalculationModel());
		model.addAttribute(new OperatorModel());	
	}
	
}
