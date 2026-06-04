package com.codingshuttle.prav.module1;

//import org.springframework.beans.factory.annotation.Autowired; BAD?
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RequiredArgsConstructor
public class Module1Application implements CommandLineRunner {


	private final PaymentService paymentService;

	private final NotificationService notificationService;

	public Module1Application(PaymentService paymentService,
			NotificationService notificationService) {
		this.paymentService = paymentService;
		this.notificationService = notificationService;
	}

//	public Module1Application(PaymentService paymentService,
//			@Qualifier("email") NotificationService notificationService) {
//		this.paymentService = paymentService;
//		this.notificationService = notificationService;
//	}


	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();
		notificationService.send("Payment of $100 processed successfully.");
	}
}
