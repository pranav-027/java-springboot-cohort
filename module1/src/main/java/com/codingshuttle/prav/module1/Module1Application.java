package com.codingshuttle.prav.module1;

//import org.springframework.beans.factory.annotation.Autowired; BAD?
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {


	private final PaymentService paymentService;

	Module1Application(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();
	}
}
