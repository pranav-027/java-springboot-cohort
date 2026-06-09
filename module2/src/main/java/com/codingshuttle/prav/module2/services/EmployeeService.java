package com.codingshuttle.prav.module2.services;

import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import java.util.List;

public interface EmployeeService {

	EmployeeDto getEmployeeById(long id);

	List<EmployeeDto> getEmployees();

	EmployeeDto createEmployee(EmployeeDto employeeDto);

}
