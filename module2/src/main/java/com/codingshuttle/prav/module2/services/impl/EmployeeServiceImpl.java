package com.codingshuttle.prav.module2.services.impl;

import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import com.codingshuttle.prav.module2.repositories.EmployeeRepository;
import com.codingshuttle.prav.module2.services.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
		return modelMapper.map(employeeEntity, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<EmployeeEntity> employeeList = employeeRepository.findAll();
		return employeeList
				.stream()
				.map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		EmployeeEntity toSaveEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		EmployeeEntity savedEntity = employeeRepository.save(toSaveEntity);
		return modelMapper.map(savedEntity, EmployeeDto.class);
	}
}
