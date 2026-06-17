package com.codingshuttle.prav.hospitalManagementSystem.entity;


import com.codingshuttle.prav.hospitalManagementSystem.enums.BloodGroupType;
import com.codingshuttle.prav.hospitalManagementSystem.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@ToString
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

}
