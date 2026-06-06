package com.homework.cakebaker.service.impl;

import com.homework.cakebaker.service.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Qualifier("strawberryFrosting")
@ConditionalOnProperty(value = "frosting.type", havingValue = "STRAWBERRY")
public class StrawberryFrosting implements Frosting {

	@Override
	public String getFrostingType() {
		return "Strawberry Frosting";
	}
}
