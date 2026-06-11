package com.codingshuttle.prav.module2.services;

import com.codingshuttle.prav.module2.dto.DepartmentDto;
import java.util.List;

public interface DepartmentService {

	List<DepartmentDto> getAllDepartments();
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
	void deleteDepartment(Long id);
	DepartmentDto getDepartmentById(Long id);

}
