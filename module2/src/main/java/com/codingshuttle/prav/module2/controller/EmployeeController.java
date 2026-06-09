package com.codingshuttle.prav.module2.controller;


import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import com.codingshuttle.prav.module2.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping(path = "/{employeeId}")
	// @PathVariable(name = "employeeId")
	public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	@GetMapping
	public List<EmployeeEntity> getEmployees(@RequestParam(required = false) String sortBy) {
		return employeeRepository.findAll();
	}

	@PostMapping
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeDto) {
		return employeeRepository.save(employeeDto);
	}

}
