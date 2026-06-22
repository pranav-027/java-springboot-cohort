package com.codingshuttle.prav.hospitalManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false )
	private String name;

	private String specialization;

	private String email;

	@OneToMany(mappedBy = "doctor")
	private Set<Appointment> appointments = new HashSet<>();

	@ManyToMany(mappedBy = "doctors")
	private Set<Department> departments = new HashSet<>();

}
