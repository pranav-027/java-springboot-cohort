package com.codingshuttle.prav.hospitalManagementSystem.service;

import com.codingshuttle.prav.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.prav.hospitalManagementSystem.entity.Doctor;
import com.codingshuttle.prav.hospitalManagementSystem.entity.Patient;
import com.codingshuttle.prav.hospitalManagementSystem.repository.AppointmentRepository;
import com.codingshuttle.prav.hospitalManagementSystem.repository.DoctorRepository;
import com.codingshuttle.prav.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

	private final DoctorRepository doctorRepository;
	private final AppointmentRepository appointmentRepository;
	private final PatientRepository patientRepository;

	@Transactional //not necessary but handles rollback
	public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId) {
		Patient patient = patientRepository.findById(patientId).orElseThrow();
		Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

		appointment.setPatient(patient);
		appointment.setDoctor(doctor);

		return appointmentRepository.save(appointment);
	}

}
