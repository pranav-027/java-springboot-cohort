package com.codingshuttle.prav.module1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Service
//@Repository
//@Controller
//@RestController
public class PaymentService {

	private String paymentType;

	public void pay() {
		System.out.println("Paying with " + paymentType);
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@PostConstruct
	public void afterInit() {
		System.out.println("Before Payment Service");
	}

	@PreDestroy
	public void beforeDestroy() {
		System.out.println("After Payment method");
	}

}
