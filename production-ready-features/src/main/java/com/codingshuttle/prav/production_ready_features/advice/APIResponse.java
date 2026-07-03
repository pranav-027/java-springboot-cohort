package com.codingshuttle.prav.production_ready_features.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class APIResponse<T> {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeStamp;
	private T data;
	private ApiError apiError;

	public APIResponse() {
		this.timeStamp = LocalDateTime.now();
	}
	public APIResponse(T data) {
		this();
		this.data = data;
	}
	public APIResponse(ApiError apiError) {
		this();
		this.apiError = apiError;
	}

}
