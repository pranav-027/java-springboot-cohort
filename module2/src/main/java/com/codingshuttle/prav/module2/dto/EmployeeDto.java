package com.codingshuttle.prav.module2.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
public class EmployeeDto {

	Long id;
	String name;
	String email;
	Integer age;
	LocalDate joiningDate;
	Boolean active;
}
