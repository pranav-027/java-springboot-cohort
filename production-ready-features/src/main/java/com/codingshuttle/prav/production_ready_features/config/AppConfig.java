package com.codingshuttle.prav.production_ready_features.config;


import com.codingshuttle.prav.production_ready_features.auth.AuditorAwareImpl;
import com.codingshuttle.prav.production_ready_features.entities.AuditLineEntity;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.temporal.TemporalAccessor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware" )
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer() {
		return builder -> builder.serializationInclusion(Include.NON_NULL);
	}

	@Bean
	public AuditorAware<String> getAuditorAware() {
		return new AuditorAwareImpl();
	}

}
