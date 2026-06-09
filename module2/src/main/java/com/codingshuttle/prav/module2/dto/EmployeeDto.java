package com.codingshuttle.prav.module2.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	Long id;
	String name;
	String email;
	Integer age;
	LocalDate joiningDate;
	Boolean active;
}
