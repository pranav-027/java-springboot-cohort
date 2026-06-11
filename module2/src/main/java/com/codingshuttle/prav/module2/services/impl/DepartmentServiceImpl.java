package com.codingshuttle.prav.module2.services.impl;

import com.codingshuttle.prav.module2.dto.DepartmentDto;
import com.codingshuttle.prav.module2.entities.DepartmentEntity;
import com.codingshuttle.prav.module2.exceptions.ResourceNotFoundException;
import com.codingshuttle.prav.module2.repositories.DepartmentRepository;
import com.codingshuttle.prav.module2.services.DepartmentService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
		this.departmentRepository = departmentRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		return departmentRepository.findAll()
				.stream()
				.map(department -> modelMapper.map(department, DepartmentDto.class))
				.toList();
	}

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
		return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
	}

	@Override
	public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
		isDepartmentExisting(id);
		DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
		departmentEntity.setId(id);
		return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDto.class);
	}

	@Override
	public void deleteDepartment(Long id) {
		isDepartmentExisting(id);
		departmentRepository.deleteById(id);
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		isDepartmentExisting(id);
		return modelMapper.map(departmentRepository.findById(id).orElse(null), DepartmentDto.class);
	}

	private void isDepartmentExisting(Long id){
		if (!departmentRepository.existsById(id)) throw new ResourceNotFoundException("Department with id " + id + " not found");
	}
}
