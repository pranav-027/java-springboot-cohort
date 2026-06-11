package com.codingshuttle.prav.module2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

	private Long id;

	@NotEmpty
	@Size(min = 3, max = 30, message = "Department title must be between 3 to 30 characters")
	private String title;

	private Boolean isActive;

	@PastOrPresent(message = "Creation date cannot be in the future")
	private LocalDate createAt;
}
