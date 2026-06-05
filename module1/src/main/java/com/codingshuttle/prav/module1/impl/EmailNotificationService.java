package com.codingshuttle.prav.module1.impl;

import com.codingshuttle.prav.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Qualifier("email")
@Service
@ConditionalOnProperty(name = "notification.type", havingValue = "EMAIL")
public class EmailNotificationService implements NotificationService {

	@Override
	public void send(String message) {
		System.out.println("Sending Email notification: " + message);
	}

}
