package com.codingshuttle.prav.production_ready_features.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private Long id;
	private String title;
	private String description;


}
