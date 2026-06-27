package com.codingshuttle.prav.production_ready_features.advice;

import com.codingshuttle.prav.production_ready_features.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
		 ApiError apiError = ApiError.builder()
				.statusCode(HttpStatus.NOT_FOUND)
				.error(List.of(ex.getMessage()))
				.build();
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
