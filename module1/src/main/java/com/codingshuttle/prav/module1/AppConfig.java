package com.codingshuttle.prav.module1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Value("${payment.type}")
	private String paymentType;

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	PaymentService paymentService() {
		PaymentService paymentService = new PaymentService();
		paymentService.setPaymentType(paymentType);
		return paymentService;
	}
   // Tells how to create a bean
}
