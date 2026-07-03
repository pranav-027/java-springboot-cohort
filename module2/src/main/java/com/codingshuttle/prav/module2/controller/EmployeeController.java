package com.codingshuttle.prav.module2.controller;


import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.exceptions.ResourceNotFoundException;
import com.codingshuttle.prav.module2.services.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/{employeeId}")
	// @PathVariable(name = "employeeId")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
		EmployeeDto response = employeeService.getEmployeeById(employeeId);
		if (response == null) throw new ResourceNotFoundException("Employee not found");
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestParam(required = false) String sortBy) {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDto));
	}


	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId) {
		if (employeeService.deleteEmployeeWithId(employeeId)) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PatchMapping("/{employeeId}")
	public ResponseEntity<EmployeeDto> patchEmployee(@PathVariable Long employeeId, @RequestBody Map<String,Object> employeeData) {
		EmployeeDto response = employeeService.patchEmployee(employeeId, employeeData);
		if (response == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(response);
		}
	}
}
