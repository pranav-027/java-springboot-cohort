package com.codingshuttle.prav.hospitalManagementSystem.model;

import com.codingshuttle.prav.hospitalManagementSystem.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientInfo {

	private final Long id;
	private final String name;

}
