package com.codingshuttle.prav.hospitalManagementSystem.entity;


import com.codingshuttle.prav.hospitalManagementSystem.enums.BloodGroupType;
import com.codingshuttle.prav.hospitalManagementSystem.enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	private BloodGroupType bloodGroup;

	@CreationTimestamp
	private LocalDate createAt;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "patient_insurance")
	private Insurance insurance;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private Set<Appointment> appointments = new HashSet<>();

	@Override
	public String toString() {
		return "Patient{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", birthDate=" + birthDate +
				", bloodGroup=" + bloodGroup +
				", createAt=" + createAt +
				", insurance=" + insurance.getProvider() +
				'}';
	}
}
