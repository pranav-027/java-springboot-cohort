package com.codingshuttle.prav.production_ready_features.advice;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class ApiError {

	private LocalDateTime timeStamp;
	private HttpStatus statusCode;
	private List<String> error;

	public ApiError() {
		this.timeStamp = LocalDateTime.now();
	}


	public ApiError(HttpStatus statusCode, List<String> error) {
		this();
		this.statusCode = statusCode;
		this.error = error;
	}
}
