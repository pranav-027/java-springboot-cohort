package com.codingshuttle.prav.production_ready_features.auth;

import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {


	@Override
	@SuppressWarnings("NullableProblems")
	public Optional<String> getCurrentAuditor() {

		//getSecurityContext
		// get Auth
		// get the principle
		// get the username
		return Optional.of("Pranav");
	}
}
