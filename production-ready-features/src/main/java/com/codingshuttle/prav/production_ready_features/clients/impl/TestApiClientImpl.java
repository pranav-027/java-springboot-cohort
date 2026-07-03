package com.codingshuttle.prav.production_ready_features.clients.impl;

import com.codingshuttle.prav.production_ready_features.clients.TestApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TestApiClientImpl implements TestApiClient {

	private final RestClient testApiClient;

	private final RestClient wcaRest;

	public TestApiClientImpl(@Qualifier("testApiClient") RestClient testApiClient,
			@Qualifier("wcaTest") RestClient wcaRest) {
		this.testApiClient = testApiClient;
		this.wcaRest = wcaRest;
	}

	@Override
	public String testString() throws IOException {
		try {
			ResponseEntity<String> response = testApiClient.get()
					.uri(uriBuilder -> uriBuilder
							.queryParam("type", "all-meat")
							.build())
					.retrieve()
					.toEntity(String.class);

			assert response != null;
			return response.getBody();
		} catch (Exception e) {
			System.out.println("Exception Occured");
			System.out.println(e.getMessage());
		}
		return "fail";
	}

	@Override
	public JsonNode getCompData() {
		JsonNode response = wcaRest.get()
				.retrieve()
				.body(JsonNode.class);
		assert response != null;
		return response;
	}
}
