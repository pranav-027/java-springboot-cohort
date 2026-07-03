package com.codingshuttle.prav.production_ready_features.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

	@Value("${employee.service.base.url}")
	private String BASE_URL;

	@Value("${test.api.service.base.url}")
	private String TEST_API_BASE_URL;

	@Value("${wca.api.url}")
	private String WCA_API;

	@Bean
	@Qualifier("employeeRestClient")
	public RestClient getEmployeeRestClient() {
		return RestClient.builder()
				.baseUrl(BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.defaultStatusHandler()
				.build();
	}

	@Bean
	@Qualifier("testApiClient")
	public RestClient getTestApiClient(){
		return RestClient.builder()
				.baseUrl(TEST_API_BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}


	@Bean
	@Qualifier("wcaTest")
	public RestClient getWcaClient() {
		return RestClient.builder()
				.baseUrl(WCA_API)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

}
