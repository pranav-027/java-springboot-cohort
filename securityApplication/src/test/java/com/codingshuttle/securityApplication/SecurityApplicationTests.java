package com.codingshuttle.securityApplication;

import com.codingshuttle.securityApplication.entities.User;
import com.codingshuttle.securityApplication.services.impl.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user = new User();
		user.setId(1L);
		user.setEmail("test@example.com");
		user.setPassword("password");

		String token = jwtService.generateToken(user);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token+"1");

		System.out.println(id);

	}

}
