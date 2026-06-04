package com.codingshuttle.prav.module1;

//import org.springframework.beans.factory.annotation.Autowired; BAD?
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RequiredArgsConstructor
public class Module1Application implements CommandLineRunner {


//	private final PaymentService paymentService;
//
//	private final NotificationService notificationService;


//	public Module1Application(PaymentService paymentService,
//			@Qualifier("email") NotificationService notificationService) {
//		this.paymentService = paymentService;
//		this.notificationService = notificationService;
//	}

	@Autowired
	Map<String, NotificationService> notificationServices = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		paymentService.pay();
//		notificationService.send("Payment of $100 processed successfully.");

		for(var notificationService: notificationServices.entrySet()) {
			System.out.println("Notification Service: " + notificationService.getKey());
			notificationService.getValue().send("Payment of $100 processed successfully.");
		}

	}

}
