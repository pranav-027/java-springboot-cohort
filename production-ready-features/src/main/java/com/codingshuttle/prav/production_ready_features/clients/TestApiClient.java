package com.codingshuttle.prav.production_ready_features.clients;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public interface TestApiClient {

	String testString() throws IOException;

	JsonNode getCompData();

}
