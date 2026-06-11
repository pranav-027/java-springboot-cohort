package com.codingshuttle.prav.module2.advice;

import com.codingshuttle.prav.module2.exceptions.ResourceNotFoundException;
import com.codingshuttle.prav.module2.exceptions.TechnicalException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
		ApiError apiError = ApiError
				.builder()
				.status(HttpStatus.BAD_REQUEST)
				.message(ex.getMessage())
				.build();
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<ApiError> handleTechnicalException(TechnicalException ex) {
		ApiError apiError = ApiError
				.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(ex.getMessage())
				.build();
		return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.toList();

		ApiError apiError = ApiError
				.builder()
				.status(HttpStatus.BAD_REQUEST)
				.message("Input Validation Errors")
				.errors(errors)
				.build();

		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}
