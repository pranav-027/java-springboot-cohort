package com.homework.cakebaker.service.impl;

import com.homework.cakebaker.service.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Qualifier("chocolateSyrup")
@ConditionalOnProperty(value = "syrup.type", havingValue = "CHOCOLATE")
public class ChocolateSyrup implements Syrup {

	@Override
	public String getSyrupType() {
		return "Chocolate Syrup";
	}
}
