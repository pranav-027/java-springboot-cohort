package com.codingshuttle.prav.hospitalManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime appointmentTime;

	private String reason;

	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	@ToString.Exclude
	private Patient patient;

	@ManyToOne
	@JoinColumn(nullable = false)
	@ToString.Exclude
	private Doctor doctor;
}
