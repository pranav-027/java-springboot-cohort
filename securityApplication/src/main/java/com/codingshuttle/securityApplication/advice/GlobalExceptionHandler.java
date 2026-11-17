package com.codingshuttle.securityApplication.advice;

import java.util.List;

import com.codingshuttle.securityApplication.exceptions.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex) {
		ApiError apiError = ApiError.builder()
				.statusCode(HttpStatus.UNAUTHORIZED)
				.error(List.of(ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()))
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
	}

	@ExceptionHandler(JwtException.class)
	public ResponseEntity<ApiError> handleJwtException(JwtException ex) {
		ApiError apiError = ApiError.builder()
				.statusCode(HttpStatus.UNAUTHORIZED)
				.error(List.of(ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()))
				.build();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
	}

}
