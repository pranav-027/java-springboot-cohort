package com.codingshuttle.prav.production_ready_features.clients.impl;

import com.codingshuttle.prav.production_ready_features.advice.APIResponse;
import com.codingshuttle.prav.production_ready_features.clients.EmployeeClient;
import com.codingshuttle.prav.production_ready_features.dto.EmployeeDto;
import com.codingshuttle.prav.production_ready_features.exceptions.ResourceNotFoundException;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
@Slf4j
public class EmployeeClientImpl implements EmployeeClient {

	private final RestClient restClient;

	public EmployeeClientImpl(@Qualifier("employeeRestClient") RestClient restClient) {
		this.restClient = restClient;
	}


	@Override
	public List<EmployeeDto> getAllEmployees() {
		APIResponse<List<EmployeeDto>> apiResponse =  restClient.get()
				.uri("employees")
				.retrieve()
				.body(new ParameterizedTypeReference<>() {});

		assert apiResponse != null;
		return apiResponse.getData();
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		try {
			APIResponse<EmployeeDto> apiResponse = restClient.get()
					.uri("employees/{id}", id)
					.retrieve()
					.onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
						System.out.println(Arrays.toString(res.getBody().readAllBytes()));
						throw new ResourceNotFoundException("Could Not create emp");
					})
					.onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
						System.out.println(Arrays.toString(res.getBody().readAllBytes()));
						throw new RuntimeException("Something went wrong");
					})
					.body(new ParameterizedTypeReference<>() {});
			assert apiResponse != null;
			return apiResponse.getData();
		} catch (Exception e) {
			log.error("Something went wong");
			throw new RuntimeException(e);
		}
	}

	@Override
	public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
		try {
			ResponseEntity<APIResponse<EmployeeDto>> apiResponse = restClient.post()
					.uri("employees")
					.body(employeeDto)
					.retrieve()
					.toEntity(new ParameterizedTypeReference<>() {});

			assert apiResponse.getBody() != null;
			return apiResponse.getBody().getData();

		} catch (Exception e) {
			log.error("Something went wong");
			throw new RuntimeException(e);
		}
	}

}
