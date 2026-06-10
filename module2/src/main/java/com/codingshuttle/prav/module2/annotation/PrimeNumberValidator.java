package com.codingshuttle.prav.module2.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Integer> {

	@Override
	public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
		if (integer == null) {
			return false;
		}
		if (integer < 2) {
			return false;
		}

		int i = 2;
		while (i * i <= integer) {
			if (integer % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}
