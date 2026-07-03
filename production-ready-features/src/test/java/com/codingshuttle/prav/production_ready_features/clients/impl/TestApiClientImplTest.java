package com.codingshuttle.prav.production_ready_features.clients.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.codingshuttle.prav.production_ready_features.clients.TestApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.List;
import java.util.stream.StreamSupport;
import org.hibernate.envers.Audited;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

@SpringBootTest
class TestApiClientImplTest {

	@Autowired
	private TestApiClient testApiClient;


	@Test
	void test() throws IOException {
		System.out.println(testApiClient.testString());
	}

	@Test
	void testCompData() {
		JsonNode jsonNode = testApiClient.getCompData();
		String id = jsonNode.get("id").asText();
		List<String> eventIds = StreamSupport.stream(
				jsonNode.get("event_ids").spliterator(), false)
				.map(JsonNode::asText)
				.toList();

		System.out.println(id + " :" + eventIds);
	}

}
