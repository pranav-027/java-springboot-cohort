package com.codingshuttle.prav.production_ready_features.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponseFactory {

	public static <T> ResponseEntity<T> buildOkResponse(T body) {
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

}
