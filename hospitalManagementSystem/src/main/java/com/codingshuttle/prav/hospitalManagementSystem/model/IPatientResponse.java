package com.codingshuttle.prav.hospitalManagementSystem.model;

import com.codingshuttle.prav.hospitalManagementSystem.enums.Gender;

public interface IPatientResponse {

	 Long getId();
	 String getName();
	 Gender getGender();

}
