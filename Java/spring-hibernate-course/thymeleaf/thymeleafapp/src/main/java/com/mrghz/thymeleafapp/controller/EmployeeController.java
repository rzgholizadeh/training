package com.mrghz.thymeleafapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrghz.thymeleafapp.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {
		theEmployees = new ArrayList<Employee>();
		Employee emp1 = new Employee(1, "Akbar", "Mirza", "akbar@gmail.com");
		Employee emp2 = new Employee(2, "Asghar", "Mirza", "asghar@gmail.com");
		Employee emp3 = new Employee(3, "Nemat", "Mirza", "nemat@gmail.com");
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}

}
