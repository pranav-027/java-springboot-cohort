package com.homework.cakebaker.service.impl;

import com.homework.cakebaker.service.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Qualifier("chocolateFrosting")
@ConditionalOnProperty(value = "frosting.type", havingValue = "CHOCOLATE")
public class ChocolateFrosting implements Frosting {

	@Override
	public String getFrostingType() {
		return "Chocolate Frosting";
	}
}
