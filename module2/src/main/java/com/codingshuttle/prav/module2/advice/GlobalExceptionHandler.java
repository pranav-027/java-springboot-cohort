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
	public ResponseEntity<APIResponse<?>> handleResourceNotFound(ResourceNotFoundException ex) {
		ApiError apiError = ApiError
				.builder()
				.status(HttpStatus.BAD_REQUEST)
				.message(ex.getMessage())
				.build();
		return buildErrorResponse(apiError);
	}


	@ExceptionHandler(TechnicalException.class)
	public ResponseEntity<APIResponse<?>> handleTechnicalException(TechnicalException ex) {
		ApiError apiError = ApiError
				.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message(ex.getMessage())
				.build();
		return buildErrorResponse(apiError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<APIResponse<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
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

		return buildErrorResponse(apiError);
	}

	private ResponseEntity<APIResponse<?>> buildErrorResponse(ApiError apiError) {
		return new ResponseEntity<>(new APIResponse<>(apiError), apiError.getStatus());
	}


}
