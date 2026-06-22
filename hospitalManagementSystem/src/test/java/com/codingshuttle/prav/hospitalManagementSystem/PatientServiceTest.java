package com.codingshuttle.prav.hospitalManagementSystem;

import com.codingshuttle.prav.hospitalManagementSystem.model.BloodGroupStat;
import com.codingshuttle.prav.hospitalManagementSystem.model.PatientInfo;
import com.codingshuttle.prav.hospitalManagementSystem.repository.PatientRepository;
import com.codingshuttle.prav.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientServiceTest {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientService patientService;

	@Test
	void test() {
//
//		for (IPatientResponse patient : patientRepository.getPatientInfo()) {
//			System.out.println(patient);
//		}

		for (PatientInfo patient : patientRepository.getPatientInfoConcrete()) {
			System.out.println(patient);
		}

	}

	@Test
	void testbloodGroup() {
		for (BloodGroupStat bloodGroupStat : patientRepository.getBloodGroupStat()) {
			System.out.println(bloodGroupStat);
		}
	}

	@Test
	void testUpdate() {
		System.out.println(patientRepository.updatePatientNameWithId("Johnson Doe", 1L));
	}

	@Test
	void testTran() {
		patientService.testTransaction();
	}

	@Test
	void deletePatientById() {
		patientService.deletePatient(2L);
	}

}
