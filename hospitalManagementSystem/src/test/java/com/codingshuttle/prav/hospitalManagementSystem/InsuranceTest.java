package com.codingshuttle.prav.hospitalManagementSystem;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Insurance;
import com.codingshuttle.prav.hospitalManagementSystem.service.InsuranceService;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsuranceTest {

	@Autowired
	private InsuranceService insuranceService;

	@Test
	public void testAssignInsuranceToPatient() {
		Insurance insurance = Insurance.builder()
				.provider("STAR Health")
				.expiryDate(LocalDate.of(2027,11,11))
				.sumAssured(200000.00)
				.build();

		System.out.println(insuranceService.assignInsuranceToPatient(insurance, 1L));
	}

	@Test
	public void testUpdateInsuranceToPatient() {
		Insurance insurance = Insurance.builder()
				.provider("Aditya Birla Health Health")
				.expiryDate(LocalDate.of(2027,12,11))
				.sumAssured(300000.00)
				.build();

		System.out.println(insuranceService.updateInsuranceToPatient(insurance, 1L));
	}

	@Test
	void testDeleteInsurance(){
		System.out.println(insuranceService.removeInsuranceToPatient(1L));
	}
}
