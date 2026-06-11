package com.codingshuttle.prav.module2.controller;

import com.codingshuttle.prav.module2.dto.DepartmentDto;
import com.codingshuttle.prav.module2.services.DepartmentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
		return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments(@RequestParam(required = false) String sortBy) {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	@GetMapping(path = "/{deptId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long deptId) {
		return ResponseEntity.ok(departmentService.getDepartmentById(deptId));
	}

	@PutMapping(path = "/{deptId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long deptId, @RequestBody @Valid DepartmentDto departmentDto) {
		return ResponseEntity.ok(departmentService.updateDepartment(deptId, departmentDto));
	}

	@DeleteMapping(path = "/{deptId}")
	public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long deptId) {
		departmentService.deleteDepartment(deptId);
		return ResponseEntity.noContent().build();
	}

}
