package com.codingshuttle.prav.module1.impl;

import com.codingshuttle.prav.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Qualifier("sms")
@Service
@ConditionalOnProperty(name = "notification.type", havingValue = "SMS")
public class SmsNotificationService implements NotificationService {


	@Override
	public void send(String message) {
		System.out.println("Sending SMS notification: " + message);
	}
}
