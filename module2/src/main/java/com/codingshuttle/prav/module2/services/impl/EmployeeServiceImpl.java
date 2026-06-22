package com.codingshuttle.prav.module2.services.impl;

import com.codingshuttle.prav.module2.dto.EmployeeDto;
import com.codingshuttle.prav.module2.entities.EmployeeEntity;
import com.codingshuttle.prav.module2.exceptions.ResourceNotFoundException;
import com.codingshuttle.prav.module2.exceptions.TechnicalException;
import com.codingshuttle.prav.module2.repositories.EmployeeRepository;
import com.codingshuttle.prav.module2.services.EmployeeService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;
	private final ObjectMapper objectMapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
		this.objectMapper = objectMapper;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		return employeeEntity.map(entity -> modelMapper.map(entity, EmployeeDto.class))
				.orElse(null);
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

	@Override
	public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
		if (!employeeExists(employeeId)) throw new ResourceNotFoundException("Employee with id: " + employeeId + " does not exist");
		EmployeeEntity toUpdatedEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
		toUpdatedEntity.setId(employeeId);
		EmployeeEntity savedEntity = employeeRepository.save(toUpdatedEntity);
		return modelMapper.map(savedEntity, EmployeeDto.class);
	}

	@Override
	public boolean deleteEmployeeWithId(Long employeeId) {
		if (employeeExists(employeeId)) {
			employeeRepository.deleteById(employeeId);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeDto patchEmployee(Long employeeId, Map<String, Object> employeeData) {
		if (!employeeExists(employeeId)) {
			return null;
		}
		try {
			EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
			//this is also possible by ReflectionUtils
			objectMapper.updateValue(employeeEntity, employeeData);
			return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);
		} catch (JsonMappingException e) {
			throw new TechnicalException("Error while patching employee with id: " + employeeId, e);
		}
	}

	private boolean employeeExists(Long employeeId) {
		return employeeRepository.existsById(employeeId);
	}
}
