package com.codingshuttle.prav.production_ready_features.clients;

import com.codingshuttle.prav.production_ready_features.dto.EmployeeDto;
import java.util.List;

public interface EmployeeClient {

	List<EmployeeDto> getAllEmployees();

	EmployeeDto getEmployeeById(Long id);

	EmployeeDto createNewEmployee(EmployeeDto employeeDto);
}
