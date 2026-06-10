package com.codingshuttle.prav.module2.dto;

import com.codingshuttle.prav.module2.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

	private Long id;

	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 10, message = "Name must be between 3 and 10 characters")
	private String name;

	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Max(value = 80, message = "Age must be less than or equal to 80")
	@Min(value = 18, message = "Age must be greater than or equal to 18")
	private Integer age;

	@PastOrPresent
	private LocalDate joiningDate;

	@FutureOrPresent
	private LocalDate lastWorkingDate;

	@Positive(message = "Salary must be positive")
	@Digits(integer = 7, fraction = 2, message = "Salary must be a valid number with up to 7 digits and 2 decimal places")
	private Double salary;

	private Boolean active;

	@NotNull(message = "Role cannot be null")
//	@Pattern(regexp = "^(ADMIN|USER)$", flags = Flag.CASE_INSENSITIVE, message = "Role must be either ADMIN or USER")
	@EmployeeRoleValidation
	private String role;

}
