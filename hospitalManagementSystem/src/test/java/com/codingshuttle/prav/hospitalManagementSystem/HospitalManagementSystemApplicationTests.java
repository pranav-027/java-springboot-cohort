package com.codingshuttle.prav.hospitalManagementSystem;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.prav.hospitalManagementSystem.service.AppointmentService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementSystemApplicationTests {

	@Autowired
	AppointmentService appointmentService;


	@Test
	void contextLoads() {
	}

	@Test
	void testAppointment() {
		Appointment appointment = Appointment.builder()
				.appointmentTime(LocalDateTime.now())
				.reason("General Checkup")
				.build();

		System.out.println(appointmentService.createNewAppointment(appointment, 2L, 1L));

	}

}
