package com.codingshuttle.prav.module2.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
		return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
