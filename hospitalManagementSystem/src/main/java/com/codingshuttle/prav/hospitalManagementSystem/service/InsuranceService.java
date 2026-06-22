package com.codingshuttle.prav.hospitalManagementSystem.service;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.prav.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.prav.hospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

	private final PatientRepository patientRepository;


	@Transactional
	public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow();

		patient.setInsurance(insurance); // this handles everything in relation as owing entity

		insurance.setPatient(patient); // optional -> done for bidirectional consistency

		return insurance;
	}

	@Transactional
	public Insurance updateInsuranceToPatient(Insurance insurance, Long patientId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow();

		patient.setInsurance(insurance); // this handles everything in relation as owing entity

		insurance.setPatient(patient); // optional -> done for bidirectional consistency

		return insurance;
	}

	@Transactional
	public Patient removeInsuranceToPatient(Long patientId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow();

		patient.setInsurance(null); // this handles everything in relation as owing entity

		return patient;
	}



}
