package com.codingshuttle.prav.hospitalManagementSystem.service;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.prav.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

	private final PatientRepository patientRepository;

	@Transactional
	public void testTransaction() {
		Patient patient1 = patientRepository.findById(1L).orElse(null);
		Patient patient2 = patientRepository.findById(1L).orElse(null);

		System.out.println(patient1 == patient2);
	}

	@Transactional
	public void deletePatient(Long id){
		patientRepository.deleteById(id);
	}
}
