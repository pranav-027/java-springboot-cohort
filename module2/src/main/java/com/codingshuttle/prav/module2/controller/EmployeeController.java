package com.codingshuttle.prav.module2.controller;


import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.services.EmployeeService;
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


	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/{employeeId}")
	// @PathVariable(name = "employeeId")
	public EmployeeDto getEmployeeById(@PathVariable Long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@GetMapping
	public List<EmployeeDto> getEmployees(@RequestParam(required = false) String sortBy) {
		return employeeService.getEmployees();
	}

	@PostMapping
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}

}
