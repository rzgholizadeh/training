package com.mrghz.restcrudapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrghz.restcrudapp.entity.Employee;
import com.mrghz.restcrudapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// temporary injection (until service layer is implemented)
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee Id not fount - " + employeeId);
		}
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee save(@RequestBody Employee theEmployee) {
		// set the id to 0 in case the user has set the id in JSON already
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public int deleteById(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee Id not fount - " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return employeeId;
	}

}
