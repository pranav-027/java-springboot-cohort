package com.codingshuttle.prav.hospitalManagementSystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String provider;

	private LocalDate expiryDate;

	private Double sumAssured;

	@OneToOne(mappedBy = "insurance")
	@ToString.Exclude
	private Patient patient;


	@Override
	public String toString() {
		return "Insurance{" +
				"provider='" + provider + '\'' +
				", id=" + id +
				", expiryDate=" + expiryDate +
				", sumAssured=" + sumAssured +
				", patient=" + patient +
				'}';
	}
}
