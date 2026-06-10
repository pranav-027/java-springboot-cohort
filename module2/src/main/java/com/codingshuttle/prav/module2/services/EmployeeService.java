package com.codingshuttle.prav.module2.services;

import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

	EmployeeDto getEmployeeById(long id);

	List<EmployeeDto> getEmployees();

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);

	boolean deleteEmployeeWithId(Long employeeId);

	EmployeeDto patchEmployee(Long employeeId, Map<String, Object> employeeData);
}
